package com.shape.singleproject.service;

import com.shape.singleproject.dto.LoginKey;
import com.shape.singleproject.interceptor.LogExceptAop;
import com.shape.singleproject.interceptor.TimeAop;
import com.shape.singleproject.mapping.LoginKeyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 登陆相关服务
 */
@Component
@LogExceptAop
@TimeAop
public class LoginService {

    @Autowired
    private LoginKeyMapper loginKeyMapper;

    /**
     * 根据自定义的customKey获取登录key相关值
     * @param customKey
     * @return
     */
    public LoginKey queryLoginKeyByCustomkey(String customKey) {
        return loginKeyMapper.queryLoginKeyLimit1(LoginKey.QueryBuild()
            .customKey(customKey).build());
    }
}
