package com.shape.singleproject;

import com.alibaba.fastjson.JSON;
import com.shape.singleproject.dto.ExceptInfo;
import com.shape.singleproject.dto.UserInfo;
import com.shape.singleproject.interceptor.TimeAop;
import com.shape.singleproject.mapping.ExceptInfoMapper;
import com.shape.singleproject.mapping.UserInfoMapper;
import com.shape.singleproject.service.ExceptService;
import com.shape.singleproject.service.UserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.concurrent.CountDownLatch;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SingleProjectApplication.class)
@Slf4j
public class TestUserInfoService {

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private ExceptService exceptService;

    @Test
    public void test() {
        userInfoService.testExcept("hello");
    }

    @Test
    public void testInsert() {
        exceptService.processExcept("com.sha.ee.ss#sfa", "出错啦");
    }

    @Test
    public void testEvent() throws InterruptedException {
        userInfoService.testEvent();
        new CountDownLatch(1).await();
    }

    @Test
    public void testExceptError() throws InterruptedException {
        exceptService.queryOverTimeExcept();
        new CountDownLatch(1).await();
    }

    @Test
    public void test2() throws InterruptedException {
        try {
            userInfoService.test();
        } catch (Exception e) {
            System.out.println("出错啦");
        }
        new CountDownLatch(1).await();
    }
}
