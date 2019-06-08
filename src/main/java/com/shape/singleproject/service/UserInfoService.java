package com.shape.singleproject.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.shape.singleproject.constant.ConstellationEnum;
import com.shape.singleproject.constant.EducationEnum;
import com.shape.singleproject.constant.UserStatusEnum;
import com.shape.singleproject.domain.OpenidValue;
import com.shape.singleproject.dto.AttentionInfo;
import com.shape.singleproject.dto.LoginKey;
import com.shape.singleproject.dto.Tags;
import com.shape.singleproject.dto.UserInfo;
import com.shape.singleproject.interceptor.LogExceptAop;
import com.shape.singleproject.interceptor.TimeAop;
import com.shape.singleproject.mapper.CustomUserInfoMapper;
import com.shape.singleproject.mapping.AttentionInfoMapper;
import com.shape.singleproject.mapping.LoginKeyMapper;
import com.shape.singleproject.mapping.UserInfoMapper;
import com.shape.singleproject.util.CacheUtil;
import com.shape.singleproject.util.HttpUtil;
import com.shape.singleproject.util.Md5Util;
import com.shape.singleproject.util.RandomUtil;
import com.shape.singleproject.vo.PageResult;
import com.shape.singleproject.vo.Result;
import com.shape.singleproject.vo.UserInfoQuery;
import com.shape.singleproject.vo.UserInfoVo;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;


@Component
@LogExceptAop
@TimeAop
public class UserInfoService implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher applicationEventPublisher;

    @Resource
    private HttpUtil httpUtil;

    @Resource
    private UserInfoMapper userInfoMapper;

    @Resource
    private AttentionInfoMapper attentionInfoMapper;

    @Resource
    private LoginKeyMapper loginKeyMapper;

    public JSONObject uploadImg(MultipartFile file) throws IOException {
        return httpUtil.uploadFile(file);
    }

    public boolean deleteImg(String md5) throws IOException {
        return httpUtil.deleteImage(md5);
    }

    public JSONObject login(String code) throws IOException {
        JSONObject jsonResult = new JSONObject();
        // 1.先请求微信服务器
       JSONObject jsonObject = httpUtil.getWxOpenid(code);
       if (!Optional.ofNullable(jsonObject.getString("openid")).isPresent()) {
           throw new RuntimeException("UserInfoService.login error message: " + jsonObject.toJSONString());
       }else {
           String openId = jsonObject.getString("openid");
           String sessionKey = jsonObject.getString("session_key");
           String sessionId = Md5Util.encry(openId, sessionKey);

           // 查询是否有sessionId
           LoginKey existLoginKey = loginKeyMapper.queryLoginKeyLimit1(LoginKey.QueryBuild().openId(openId));
           if (existLoginKey == null) {
               // 没有的话就插入一条
               LoginKey newKey = new LoginKey(null,sessionId, openId, sessionKey, LocalDateTime.now());
               loginKeyMapper.insertLoginKey(newKey);
           }else {
               existLoginKey.setCustomKey(sessionId);
               existLoginKey.setOpenId(openId);
               existLoginKey.setSessionKey(sessionKey);
               loginKeyMapper.updateLoginKey(existLoginKey);
           }
           jsonResult.put("sessionId", sessionId);
           return jsonResult;
       }
    }


    /**
     * 插入用户信息
     * @param userInfo
     */
    @Transactional
    public Result insertUser(UserInfo userInfo, OpenidValue openidValue) {

        Result result = new Result();

        userInfo.setOpenId(openidValue.getOpenId());

        if (!checkAddOrUpdateUserInfo(result, userInfo)) {
            return result;
        }

        UserInfo existUserInfo = queryUserInfoByOpenid(userInfo.getOpenId());
        if (null != existUserInfo) {
            result.setMessage("用户信息已存在");
            return result;
        }

        userInfo.setStatus(UserStatusEnum.WAIT.getStatus());
        userInfo.setModified(LocalDateTime.now());
        userInfoMapper.insertUserInfo(userInfo);

        if (CacheUtil.get(CacheUtil.USER_NOT_EXIT_PREFIX + openidValue.getOpenId()) != null) {
            CacheUtil.put(CacheUtil.USER_NOT_EXIT_PREFIX + openidValue.getOpenId(), CacheUtil.CACHE_FALSE_FLAG);
        }
        result.setSuccess(true);
        return result;
    }

    /**
     * 批量查询所有用户信息
     * @param userInfo
     * @return
     */
    public List<UserInfo> queryUserInfo(UserInfo userInfo) {
        return userInfoMapper.queryUserInfo(userInfo);
    }

    /**
     * 分页查询所有用户信息(不带有微信号和咚咚号）
     * 列表页展示基本信息
     * 返回当前页数据
     */
    public PageResult<UserInfo> queryUserInfoByPage(UserInfoQuery userInfoQuery, String openId) {
        PageHelper.startPage(userInfoQuery.getPageIndex(), userInfoQuery.getPageSize());
        List<UserInfo> userInfoList = userInfoMapper.queryUserInfo(UserInfo.QueryBuild()
                                        .fetchOpenId()
                                        .fetchBirthday()
                                        .fetchConstellation()
                                        .fetchDepartment()
                                        .fetchName()
                                        .fetchEducation()
                                        .fetchPhotos()
                                        .fetchProvince()
                                        .fetchCity()
                                        .fetchSex()
                                        .fetchActivityTags()
                                        .fetchDoingTags()
                                        .fetchPlanTags()
                                        .yn(0)
                                        .status(UserStatusEnum.SUCCESS.getStatus()).build());
        userInfoList = userInfoList.stream().filter(userInfo -> !userInfo.getOpenId().equals(openId)).collect(Collectors.toList());
        PageInfo pageInfo = new PageInfo(userInfoList);
        return PageResult.build()
                .setDataList(pageInfo.getList())
                .setTotalPage(pageInfo.getPages())
                .setTotalCount(pageInfo.getTotal())
                .setSuccess(true);
    }

    /**
     * 根据openid查询用户信息
     * @param openid
     * @return
     */
    public UserInfo queryUserInfoByOpenid(String openid) {
        return userInfoMapper.queryUserInfoLimit1(UserInfo.QueryBuild()
            .excludeWxNumber()
            .excludeDongdong()
            .openId(openid)
            .yn(0));
    }

    /**
     * 根据openid查询用户隐私信息
     */
    public UserInfo queryUserInfoSecretByOpen(String openid, String originOpenId) {

        // 检查是否满足条件查看
        AttentionInfo attentionInfo = attentionInfoMapper.queryAttentionInfoLimit1(
                AttentionInfo.QueryBuild()
                        .toAttentionOpenid(openid)
                        .attentionOpenid(originOpenId)
                        .build()
        );
        AttentionInfo selfAttentionInfo = attentionInfoMapper.queryAttentionInfoLimit1(
                AttentionInfo.QueryBuild()
                        .toAttentionOpenid(originOpenId)
                        .attentionOpenid(openid)
                        .build()
        );

        if (null != attentionInfo && null != selfAttentionInfo) {
            return userInfoMapper.queryUserInfoLimit1(UserInfo.QueryBuild()
                    .fetchWxNumber()
                    .fetchDongdong()
                    .openId(openid)
                    .yn(0));
        }else {
            return null;
        }
    }

    public UserInfo queryUserInfoExist(String openId) {
        return userInfoMapper.queryUserInfoLimit1(UserInfo.QueryBuild()
            .fetchOpenId()
            .openId(openId)
            .yn(0));
    }

    /**
     * 用于用户查询自己的信息
     * @param openid
     * @return
     */
    public UserInfo queryUserInfoByOpenIdNonSecurity(String openid) {
        if (CacheUtil.get(CacheUtil.USER_NOT_EXIT_PREFIX + openid) != null &&
                CacheUtil.get(CacheUtil.USER_NOT_EXIT_PREFIX + openid).equals(CacheUtil.CACHE_TRUE_FLAG)) {
            System.out.println("缓存命中:" + openid);
            return null;
        }
        UserInfo userInfo = userInfoMapper.queryUserInfoLimit1(UserInfo.QueryBuild()
                .excludeOpenId()
                .openId(openid));
        if (userInfo == null) {
            CacheUtil.put(CacheUtil.USER_NOT_EXIT_PREFIX + openid, CacheUtil.CACHE_TRUE_FLAG);
            return null;
        }
        return userInfo;
    }

    /**
     * 根据openid修改用户信息
     * @param userInfo
     */
    public Result updateUserInfoBasic(UserInfo userInfo ,OpenidValue openidValue) {

        Result result = new Result();

        if (!checkAddOrUpdateUserInfo(result, userInfo)) {
            return result;
        }

        UserInfo existUserInfo = queryUserInfoByOpenid(userInfo.getOpenId());
        if (null == existUserInfo) {
            result.setMessage("用户信息不存在或者已失效，无法修改");
            return result;
        }

        userInfo.setModified(LocalDateTime.now());
//        userInfo.setStatus(UserStatusEnum.WAIT.getStatus());
        userInfoMapper.updateUserInfoBasicByOpenId(userInfo);

        result.setSuccess(true);
        return result;
    }

    /**
     * 根据openId非物理删除用户信息
     * 非物理删除是把yn 是否有效置为0
     * 这样的好处就是可以恢复数据
     * @param openId
     */
    public Result deleteUserInfoNonPhysical(String openId) {
        Result result = new Result();

        if (StringUtils.isEmpty(openId)) {
            result.setMessage("openId不能为空");
            return result;
        }

        UserInfo userInfo = queryUserInfoByOpenid(openId);

        if (null == userInfo) {
            result.setMessage("用户信息不存在或已失效,无法删除!");
            return result;
        }

        userInfoMapper.update(UserInfo.UpdateBuild()
            .set(UserInfo.Build()
                    .yn(0)
                    .build()
            ).where(UserInfo.ConditionBuild()
                .openIdList(openId))
                .build()
        );
        result.setSuccess(true);
        return result;
    }

    /**
     * 查看其他人的信息
     * @param openId
     * @param currentOpenId
     * @return
     */
    public Result<UserInfoVo> getOtherUserInfo(String openId, String currentOpenId) {
        Result result = new Result();

        UserInfo userInfo = queryUserInfoByOpenid(openId);
        if (null == userInfo) {
            result.setMessage("没有该用户的信息");
            return result;
        }

        UserInfoVo userInfoVo = CustomUserInfoMapper.INSTANCE.info2VoWithAttentionAndTag(userInfo, currentOpenId);
        result.setSuccess(true);
        result.setData(userInfoVo);
        return result;
    }

    /**
     * 关注
     * @param targetOpenId 关注目标OpenId
     * @param originOpenId 发起关注OpenId
     * @return
     */
    @Transactional
    public JSONObject attentionAction(String targetOpenId, String originOpenId) {
        JSONObject jsonObject = new JSONObject();

        UserInfo userInfo = queryUserInfoByOpenIdNonSecurity(originOpenId);

        if (null == userInfo) {
            jsonObject.put("success", false);
            jsonObject.put("message", "不是真正的用户");
            return jsonObject;
        }

        if (userInfo.getStatus().equals(0)) {
            jsonObject.put("success", false);
            jsonObject.put("message", "请等待审核！");
            return jsonObject;
        }

        // 1.关注了肯定是没有的 所以先插入数据
        attentionInfoMapper.insertAttentionInfo(AttentionInfo.Build()
                .attentionOpenid(originOpenId)
                .toAttentionOpenid(targetOpenId)
                .build());
        jsonObject.put("success", true);
        // 2.然后查询一下被关注信息 看是不是已经互相关注
        AttentionInfo selfAttentionInfo = attentionInfoMapper.queryAttentionInfoLimit1(
                AttentionInfo.QueryBuild()
                        .toAttentionOpenid(originOpenId)
                        .attentionOpenid(targetOpenId)
                        .build());
        if (null != selfAttentionInfo) {
            jsonObject.put("allAttention", true);
        }

        return jsonObject;
    }

    /**
     * 取消关注
     * @param targetOpenId
     * @param originOpenId
     * @return
     */
    public boolean cancelAttentionAction(String targetOpenId, String originOpenId) {
        UserInfo userInfo = queryUserInfoByOpenIdNonSecurity(originOpenId);
        //取消关注就直接删除记录
        attentionInfoMapper.delete(AttentionInfo.Build()
        .attentionOpenid(originOpenId)
        .toAttentionOpenid(targetOpenId)
        .build());
        return true;
    }

    /**
     * 随机查询指定数量的用户信息
     * @param size 指定数量
     * @param openId 登录用户
     * @return
     */
    public List<UserInfo> randomQueryUserInfo(Integer size, String openId) {
        if (size == null || size == 0 || StringUtils.isEmpty(openId)) {
            return Lists.newArrayList();
        }
        List<Long> ids = userInfoMapper.queryAllId(openId);
        Set<Long> randomIds = RandomUtil.getUniqueIdSetByListWithLong(ids, size);
        if (CollectionUtils.isEmpty(randomIds)) {
            return Lists.newArrayList();
        }
        return userInfoMapper.queryUserInfo(UserInfo.QueryBuild()
                .fetchOpenId()
                .fetchBirthday()
                .fetchConstellation()
                .fetchDepartment()
                .fetchName()
                .fetchEducation()
                .fetchPhotos()
                .fetchProvince()
                .fetchCity()
                .fetchSex()
                .fetchActivityTags()
                .fetchDoingTags()
                .fetchPlanTags()
                .idList(Lists.newArrayList(randomIds)));
    }


    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }


    /**
     * 校验新建和更新的用户信息
     * @param result 校验结果集
     * @param userInfo 要校验的对象
     * @return 返回信息
     */
    private boolean checkAddOrUpdateUserInfo(Result result, UserInfo userInfo) {
        if (StringUtils.isEmpty(userInfo.getOpenId())) {
            result.setMessage("openId不能为空");
            return false;
        }

        if (StringUtils.isEmpty(userInfo.getName())) {
            result.setMessage("昵称不能为空");
            return false;
        }

        if (StringUtils.isEmpty(userInfo.getPhotos())) {
            result.setMessage("上传照片不能为空");
            return false;
        }

        if (null == userInfo.getBirthday()) {
            result.setMessage("生日不能为空");
            return false;
        }

        if (null == userInfo.getSex()) {
            result.setMessage("性别不能为空");
            return false;
        }

        if (null == userInfo.getConstellation()) {
            result.setMessage("星座不能为空");
            return false;
        }

        if (StringUtils.isEmpty(userInfo.getCity()) || StringUtils.isEmpty(userInfo.getProvince())) {
            result.setMessage("籍贯不能为空");
            return false;
        }

        if (StringUtils.isEmpty(userInfo.getWxNumber())) {
            result.setMessage("微信号不能为空");
            return false;
        }

        if (StringUtils.isEmpty(userInfo.getDongdong())) {
            result.setMessage("咚咚号不能为空");
            return false;
        }

        if (StringUtils.isEmpty(userInfo.getWorkArea())) {
            result.setMessage("工作地址不能为空");
            return false;
        }

        if (StringUtils.isEmpty(userInfo.getHeight())) {
            result.setMessage("身高不能为空");
            return false;
        }

        if (StringUtils.isEmpty(userInfo.getWeight())) {
            result.setMessage("体重不能为空");
            return false;
        }

        if (StringUtils.isEmpty(userInfo.getDepartment())) {
            result.setMessage("所在部门不能为空");
            return false;
        }

        return true;
    }

}
