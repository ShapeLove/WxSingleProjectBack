package com.shape.singleproject;

import com.alibaba.fastjson.JSONObject;
import com.shape.singleproject.util.HttpUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SingleProjectApplication.class)
@Slf4j
public class TestHttpUtil {

    @Autowired
    private HttpUtil httpUtil;

    @Test
    public void testCode() throws IOException {
        JSONObject result = httpUtil.getWxOpenid("033TanWi2PBqxH0HwkVi2TUaWi2TanWw");
        System.out.println(result.toJSONString());
    }

    @Test
    public void testUpload() throws IOException {
    }

    @Test
    public void testDelete() throws IOException, InterruptedException {
        String md5 = "74375658b3d23ce24223bccbb6837a2a";
        try {
            System.out.println(httpUtil.deleteImage(md5));
        }catch (Exception e) {
            e.printStackTrace();
        }
        new CountDownLatch(1).await();
    }
}
