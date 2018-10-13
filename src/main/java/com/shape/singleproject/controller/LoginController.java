package com.shape.singleproject.controller;

import com.shape.singleproject.service.UserInfoService;
import com.shape.singleproject.util.CacheUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * 登陆
 */
@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserInfoService userInfoService;


    @RequestMapping("/getSecurity")
    public boolean getSecurity(String sessionId) {
        return Optional.ofNullable(CacheUtil.getOpenIdValue(sessionId))
                .isPresent();
    }

    @RequestMapping("/login")
    public String login(String code) {
        return null;
    }
}
