package com.shape.singleproject.service;

import com.shape.singleproject.dto.UserInfo;
import com.shape.singleproject.event.ExceptEvent;
import com.shape.singleproject.interceptor.LogExceptAop;
import com.shape.singleproject.interceptor.TimeAop;
import com.shape.singleproject.mapping.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@LogExceptAop
public class UserInfoService implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher applicationEventPublisher;

    @Autowired
    private UserInfoMapper userInfoMapper;

    public List<UserInfo> queryUserInfo(UserInfo userInfo) {
        return userInfoMapper.queryUserInfo(userInfo);
    }

    public int delete(UserInfo.UpdateBuilder updateBuilder) {
        return userInfoMapper.update(updateBuilder);
    }

    public int testExcept(String hello) {
        System.out.println("开始 hellotestExcept");
        if (true) {
            throw new RuntimeException("报错啦");
        }
        return 1;
    }


    public void testEvent() {
        applicationEventPublisher.publishEvent(new ExceptEvent("hha", "sdfs"));
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public void test() {
        throw new RuntimeException("出错啦");
    }
}
