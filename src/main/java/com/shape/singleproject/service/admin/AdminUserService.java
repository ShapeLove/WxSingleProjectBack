package com.shape.singleproject.service.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shape.singleproject.constant.UserStatusEnum;
import com.shape.singleproject.dto.UserInfo;
import com.shape.singleproject.interceptor.LogExceptAop;
import com.shape.singleproject.interceptor.TimeAop;
import com.shape.singleproject.mapping.UserInfoMapper;
import com.shape.singleproject.util.CacheUtil;
import com.shape.singleproject.vo.AdminUserQuery;
import com.shape.singleproject.vo.PageResult;
import com.shape.singleproject.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

/**
 * 管理端服务
 */
@Component
@LogExceptAop
@TimeAop
public class AdminUserService {
    @Resource
    private UserInfoMapper userInfoMapper;

    /**
     * 管理端批量查询用户信息
     * @param adminUserQuery
     * @return
     */
    public PageResult<UserInfo> queryUserInfoByPage(AdminUserQuery adminUserQuery) {
        PageHelper.startPage(adminUserQuery.getPageIndex(), adminUserQuery.getPageSize());
        UserInfo.QueryBuilder queryBuilder = UserInfo.QueryBuild();
        queryBuilder.fetchAll();
        if (!StringUtils.isEmpty(adminUserQuery.getName())) {
            queryBuilder.name(adminUserQuery.getName());
        }
        if (null != adminUserQuery.getConstellation()) {
            queryBuilder.constellation(adminUserQuery.getConstellation());
        }
        if (!StringUtils.isEmpty(adminUserQuery.getDongdong())) {
            queryBuilder.dongdong(adminUserQuery.getDongdong());
        }
        if (null != adminUserQuery.getEducation()) {
            queryBuilder.education(adminUserQuery.getEducation());
        }
        if (null != adminUserQuery.getSex()) {
            queryBuilder.sex(adminUserQuery.getSex());
        }
        if (null != adminUserQuery.getStatus()) {
            queryBuilder.status(adminUserQuery.getStatus());
        }
        if (null != adminUserQuery.getYn()) {
            queryBuilder.yn(adminUserQuery.getYn());
        }
        if (!StringUtils.isEmpty(adminUserQuery.getWxNumber())) {
            queryBuilder.wxNumber(adminUserQuery.getWxNumber());
        }
        List<UserInfo> userInfoList = userInfoMapper.queryUserInfoDesc(queryBuilder.build());
        PageInfo pageInfo = new PageInfo(userInfoList);
        return PageResult.build()
                .setDataList(pageInfo.getList())
                .setTotalPage(pageInfo.getPages())
                .setTotalCount(pageInfo.getTotal())
                .setSuccess(true);
    }

    public UserInfo queryUserInfoByOpenId(String openId) {
        if (StringUtils.isEmpty(openId)) {
            return null;
        }

        return userInfoMapper.queryUserInfoLimit1(UserInfo.QueryBuild().openId(openId));
    }

    /**
     * 更新用户状态
     * @param userInfo
     * @return
     */
    public Result updateUserInfoStatus(UserInfo userInfo) {
        Result result = new Result();
        if (StringUtils.isEmpty(userInfo.getOpenId())) {
            result.setMessage("用户openid不能为空");
            return result;
        }
        if (null == userInfo.getStatus()) {
            result.setMessage("修改审核状态不能为空");
            return result;
        }else {
            // 如果审核状态是驳回 那么原因也不能为空
            if (userInfo.getStatus().equals(UserStatusEnum.FAIL.getStatus())) {
                if (StringUtils.isEmpty(userInfo.getRejectReason())) {
                    result.setMessage("驳回状态拒绝原因不能为空");
                    return result;
                }
            }
        }
        userInfo.setModified(LocalDateTime.now());
        userInfoMapper.updateUserInfoStatusByOpenId(userInfo);
        result.setSuccess(true);
        return result;
    }

    /**
     * 更新用户是否有效
     * @param userInfo
     * @return
     */
    public Result updateUserInfoEffect(UserInfo userInfo) {
        Result result = new Result();
        if (StringUtils.isEmpty(userInfo.getOpenId())) {
            result.setMessage("用户openid不能为空");
            return result;
        }
        if (null == userInfo.getYn()) {
            result.setMessage("有效标识不能为空");
            return result;
        }
        userInfo.setModified(LocalDateTime.now());
        userInfoMapper.updateUserInfoStatusByOpenId(userInfo);
        result.setSuccess(true);
        return result;
    }

    /**
     * 获取当前登录用户数
     * @return
     */
    public Set<String> getAllOnlineUsers() {
        return CacheUtil.getAllCache();
    }


}
