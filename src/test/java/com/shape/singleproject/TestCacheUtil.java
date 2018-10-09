package com.shape.singleproject;

import com.alibaba.fastjson.JSON;
import com.shape.singleproject.domain.OpenidValue;
import com.shape.singleproject.util.CacheUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SingleProjectApplication.class)
@Slf4j
public class TestCacheUtil {


    @Test
    public void testGet() {
        OpenidValue value = CacheUtil.getOpenIdValue("222");
        System.out.println(JSON.toJSONString(value));
    }
}
