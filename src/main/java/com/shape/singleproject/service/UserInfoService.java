package com.shape.singleproject.service;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shape.singleproject.constant.UserStatusEnum;
import com.shape.singleproject.domain.OpenidValue;
import com.shape.singleproject.dto.UserInfo;
import com.shape.singleproject.event.ExceptEvent;
import com.shape.singleproject.interceptor.LogExceptAop;
import com.shape.singleproject.interceptor.TimeAop;
import com.shape.singleproject.mapping.UserInfoMapper;
import com.shape.singleproject.util.CacheUtil;
import com.shape.singleproject.util.HttpUtil;
import com.shape.singleproject.util.Md5Util;
import com.shape.singleproject.vo.Result;
import com.shape.singleproject.vo.UserInfoQuery;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
@LogExceptAop
@TimeAop
public class UserInfoService implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher applicationEventPublisher;

    @Autowired
    private HttpUtil httpUtil;

    @Autowired
    private UserInfoMapper userInfoMapper;

    public String login(String code) throws IOException {
        // 1.先请求微信服务器
       JSONObject jsonObject = httpUtil.getWxOpenid(code);
       if (!Optional.ofNullable(jsonObject.getString("openid")).isPresent()) {
           throw new RuntimeException("UserInfoService.login error message: " + jsonObject.toJSONString());
       }else {
           OpenidValue openidValue = new OpenidValue(jsonObject.getString("openid"),
                   jsonObject.getString("session_key"));
           String sessionKey = Md5Util.encry(openidValue);
           CacheUtil.setOpenIdValue(sessionKey, openidValue);
           return sessionKey;
       }
    }


    /**
     * 插入用户信息
     * @param userInfo
     */
    public Result insertUser(UserInfo userInfo) {

        Result result = new Result();

        if (StringUtils.isEmpty(userInfo.getOpenId())) {
            result.setMessage("openid不能为空");
            return result;
        }

        UserInfo existUserInfo = queryUserInfoByOpenid(userInfo.getOpenId());
        if (null != existUserInfo) {
            result.setMessage("用户信息已存在");
            return result;
        }

        userInfo.setModified(LocalDateTime.now());
        userInfoMapper.insertUserInfo(userInfo);
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
     * 返回当前页数据
     */
    public List<UserInfo> queryUserInfoByPage(UserInfoQuery userInfoQuery) {
        PageHelper.startPage(userInfoQuery.getPageIndex(), userInfoQuery.getPageSize());
        List<UserInfo> userInfoList = userInfoMapper.queryUserInfo(UserInfo.QueryBuild()
                                        .excludeDongdong()
                                        .excludeWxNumber()
                                        .yn(0)
                                        .status(UserStatusEnum.SUCCESS.getStatus()).build());
        PageInfo pageInfo = new PageInfo(userInfoList);
        return pageInfo.getList();
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
    public UserInfo queryUserInfoSecretByOpen(String openid) {
        return userInfoMapper.queryUserInfoLimit1(UserInfo.QueryBuild()
            .fetchWxNumber()
            .openId(openid)
            .yn(0));
    }

    public UserInfo queryUserInfoByOpenIdNonSecurity(String openid) {
        return userInfoMapper.queryUserInfoLimit1(UserInfo.QueryBuild()
                .openId(openid));
    }

    /**
     * 根据openid修改用户信息
     * @param userInfo
     */
    public Result updateUserInfoBasic(UserInfo userInfo) {

        Result result = new Result();

        if (StringUtils.isEmpty(userInfo.getOpenId())) {
            result.setMessage("openid不能为空");
            return result;
        }

        UserInfo existUserInfo = queryUserInfoByOpenid(userInfo.getOpenId());
        if (null == existUserInfo) {
            result.setMessage("用户信息不存在或者已失效，无法修改");
            return result;
        }

        userInfo.setStatus(UserStatusEnum.WAIT.getStatus());
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


    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

}
