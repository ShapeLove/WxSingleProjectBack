package com.shape.singleproject.controller;

import com.shape.singleproject.configurate.LogConfigure;
import com.shape.singleproject.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.logging.LogLevel;
import org.springframework.boot.logging.LoggingSystem;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping("/changeLogDebug")
    public void changeLog() {
        LogConfigure.loggersEndpoint.configureLogLevel("root", LogLevel.DEBUG);
    }

    @RequestMapping("/changeLogInfo")
    public void changeLogINfo() {
        LogConfigure.loggersEndpoint.configureLogLevel("root", LogLevel.INFO);
    }

}
