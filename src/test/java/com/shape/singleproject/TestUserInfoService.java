package com.shape.singleproject;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.shape.singleproject.constant.EducationEnum;
import com.shape.singleproject.constant.SexEnum;
import com.shape.singleproject.dto.ExceptInfo;
import com.shape.singleproject.dto.UserInfo;
import com.shape.singleproject.interceptor.TimeAop;
import com.shape.singleproject.mapping.ExceptInfoMapper;
import com.shape.singleproject.mapping.UserInfoMapper;
import com.shape.singleproject.service.ExceptService;
import com.shape.singleproject.service.UserInfoService;
import com.shape.singleproject.util.HttpUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.CountDownLatch;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SingleProjectApplication.class)
@Slf4j
public class TestUserInfoService {

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private ExceptService exceptService;

    @Autowired
    private HttpUtil httpUtil;

    @Test
    public void testInsertUser() throws InterruptedException {
        List<String> strings = Lists.newArrayList("124123512sdafafs","vcxzxvadsf4352345", "74375658b3d23ce24223bccbb6837a2a");
        UserInfo userInfo = UserInfo.Build()
                .name("灬举个果子")
                .openId("kjdigujk2341414")
                .birthday(LocalDate.of(1996, 1, 20))
                .education(EducationEnum.DAZHUAN.getCode())
                .sex(SexEnum.BOY.getCode())
                .province("山东省")
                .city("烟台市")
                .workArea("北京市")
                .department("商家研发部-商家运营部")
                .photos(JSON.toJSONString(strings))
                .wxNumber("shpcode")
                .dongdong("sunhaipeng2")
                .build();
        try {
            userInfoService.insertUser(userInfo);
        }catch (Exception e) {
            e.printStackTrace();
        }

        new CountDownLatch(1).await();
    }
}
