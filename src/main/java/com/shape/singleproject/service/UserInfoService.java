package com.shape.singleproject.service;

import com.shape.singleproject.dto.UserInfo;
import com.shape.singleproject.interceptor.LogExceptAop;
import com.shape.singleproject.interceptor.TimeAop;
import com.shape.singleproject.mapping.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@LogExceptAop
@TimeAop
public class UserInfoService {

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
}
