package com.shape.singleproject.controller;

import com.alibaba.fastjson.JSONObject;
import com.shape.singleproject.service.UserInfoService;
import com.shape.singleproject.util.CacheUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

/**
 * 登陆
 */
@RestController
@RequestMapping("/login")
@Slf4j
public class LoginController {

    @Resource //从spring容器里把注入的服务拿出来
    private UserInfoService userInfoService;


    @RequestMapping("/getSecurity")
    public boolean getSecurity(@RequestBody String sessionId) {
        return Optional.ofNullable(CacheUtil.getOpenIdValue(sessionId))
                .isPresent();
    }

    @RequestMapping("/login")
    public JSONObject login(@RequestBody String code, HttpServletRequest request) {
        JSONObject jsonReuslt = new JSONObject();
        try {
            System.out.println(request.getHeader("sessionId"));
            jsonReuslt = userInfoService.login(code);
        }catch (Exception e) {
            log.error("LoginController.login error code:{}", code, e);
            jsonReuslt.put("error", "登录异常");
        }
        return jsonReuslt;
    }
}
