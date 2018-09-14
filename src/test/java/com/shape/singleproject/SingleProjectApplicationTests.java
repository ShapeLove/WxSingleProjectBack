package com.shape.singleproject;

import com.alibaba.fastjson.JSON;
import com.shape.singleproject.dto.UserInfo;
import com.shape.singleproject.mapping.UserInfoMapper;
import com.shape.singleproject.service.UserInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SingleProjectApplication.class)
public class SingleProjectApplicationTests {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private UserInfoService userInfoService;

    @Test
    public void contextLoads() {
        System.out.println("222");
    }

    @Test
    public void testInsert() {
        UserInfo userInfo = new UserInfo();
        userInfo.setName("shape");
        userInfo.setOptionId("j2342sxf");
        userInfoMapper.insertUserInfo(userInfo);
    }

    @Test
    public void testQuery() {
        UserInfo userInfo = UserInfo.QueryBuild()
                .fetchAll()
                .id(1L)
                .build();
        System.out.println(JSON.toJSONString(userInfoMapper.queryUserInfoLimit1(userInfo)));
    }

    @Test
    public void testUpdate() {
        UserInfo.UpdateBuilder userInfo = UserInfo.UpdateBuild()
                .set(UserInfo.Build()
                    .name("shpae222").build())
                .where(UserInfo.ConditionBuild()
                    .idList(1L).build())
                .build();
        userInfoMapper.update(userInfo);
    }

    @Test
    public void testAnnotation() {
        UserInfo userInfo = UserInfo.QueryBuild()
                .id(1L)
                .build();
        System.out.println(userInfoService.queryUserInfo(userInfo));
    }

    @Test
    public void testDelete() {
        UserInfo.UpdateBuilder updateBuilder = UserInfo.UpdateBuild()
                .set(UserInfo.Build()
                    .yn(1).build())
                .where(UserInfo.ConditionBuild()
                    .idList(1L));
        userInfoService.delete(updateBuilder);

    }

}
