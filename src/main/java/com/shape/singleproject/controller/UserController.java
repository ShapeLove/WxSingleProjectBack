package com.shape.singleproject.controller;

import com.alibaba.fastjson.JSON;
import com.shape.singleproject.dto.UserInfo;
import com.shape.singleproject.service.UserInfoService;
import com.shape.singleproject.vo.PageResult;
import com.shape.singleproject.vo.Result;
import com.shape.singleproject.vo.UserInfoQuery;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping("/queryByPage")
    public PageResult<UserInfo> queryByPage(@RequestBody UserInfoQuery userInfoQuery) {
        PageResult<UserInfo> result = new PageResult();
        try {
            result = userInfoService.queryUserInfoByPage(userInfoQuery);
        }catch (Exception e) {
            log.error("UserController.queryByPage error userInfoQuery:{}", JSON.toJSONString(userInfoQuery), e);
            result.setMessage("服务器繁忙，请稍后重试！");
        }
        return result;
    }
}
