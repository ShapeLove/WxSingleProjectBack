package com.shape.singleproject;

import com.alibaba.fastjson.JSON;
import com.shape.singleproject.service.admin.AdminUserService;
import com.shape.singleproject.vo.UserInfoVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SingleProjectApplication.class)
@Slf4j
public class TestAdminUserService {

    @Resource
    private AdminUserService adminUserService;

    @Test
    public void testQueryUserInfo() {
        UserInfoVo userInfoVo = adminUserService.queryUserInfoByOpenId("ofn5o5Dpp3qA7OD18BQpyPzhGzpM");
        System.out.println(JSON.toJSONString(userInfoVo));
        assert userInfoVo != null;
    }
}
