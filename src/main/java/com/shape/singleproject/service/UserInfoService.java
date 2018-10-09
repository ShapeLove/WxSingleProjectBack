package com.shape.singleproject.service;

import com.shape.singleproject.constant.UserStatusEnum;
import com.shape.singleproject.dto.UserInfo;
import com.shape.singleproject.event.ExceptEvent;
import com.shape.singleproject.interceptor.LogExceptAop;
import com.shape.singleproject.interceptor.TimeAop;
import com.shape.singleproject.mapping.UserInfoMapper;
import com.shape.singleproject.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.List;

@Component
@LogExceptAop
@TimeAop
public class UserInfoService implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher applicationEventPublisher;

    @Autowired
    private UserInfoMapper userInfoMapper;


    /**
     * 插入用户信息
     * @param userInfo
     */
    public void insertUser(UserInfo userInfo) {
        userInfo.setModified(LocalDateTime.now());
        userInfoMapper.insertUserInfo(userInfo);
    }

    /**
     * 批量查询
     * @param userInfo
     * @return
     */
    public List<UserInfo> queryUserInfo(UserInfo userInfo) {
        return userInfoMapper.queryUserInfo(userInfo);
    }

    /**
     * 根据openid查询用户信息
     * @param openid
     * @return
     */
    public UserInfo queryUserInfoByOpenid(String openid) {
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
            result.setMessage("该用户信息不存在，无法修改");
            return result;
        }

        userInfo.setStatus(UserStatusEnum.WAIT.getStatus());
        userInfoMapper.updateUserInfoBasicByOpenId(userInfo);

        result.setSuccess(true);
        return result;
    }


    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

}
