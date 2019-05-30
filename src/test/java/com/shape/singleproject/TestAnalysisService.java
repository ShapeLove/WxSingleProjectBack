package com.shape.singleproject;

import com.alibaba.fastjson.JSON;
import com.shape.singleproject.service.AnalysisService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.time.LocalDateTime;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SingleProjectApplication.class)
@Slf4j
public class TestAnalysisService {

    @Resource
    private AnalysisService analysisService;


    @Test
    public void testCityCount() {
        System.out.println(JSON.toJSONString(analysisService.analysisCityUserCount()));
    }

    @Test
    public void testUserCount() {
        System.out.println(JSON.toJSONString(analysisService.analysisUserCount(LocalDateTime.of(2019, 5, 25,1,1),7)));
    }

    @Test
    public void testAdminUserCount() {
        System.out.println(JSON.toJSONString(analysisService.analysisAdminUserCount(null, null)));
    }
}
