package com.shape.singleproject.controller;

import com.alibaba.fastjson.JSON;
import com.shape.singleproject.autoconfigure.GlobalConfigure;
import com.shape.singleproject.service.UserInfoService;
import com.shape.singleproject.util.CacheUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.logging.LogLevel;
import org.springframework.boot.logging.LoggingSystem;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.config.IntervalTask;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Set;

@RestController
public class IndexController {

    @Autowired
    private UserInfoService userInfoService;


    @RequestMapping("/index")
    public String index(HttpServletRequest request) {

        return "hello";
    }

    @RequestMapping("/getAllCache")
    public Set<String> getAllCache() {
        return CacheUtil.getAllCache();
    }
}
