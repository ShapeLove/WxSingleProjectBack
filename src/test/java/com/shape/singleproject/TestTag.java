package com.shape.singleproject;

import com.alibaba.fastjson.JSON;
import com.shape.singleproject.dto.Tags;
import com.shape.singleproject.dto.UserInfo;
import com.shape.singleproject.service.TagService;
import com.shape.singleproject.service.UserInfoService;
import com.shape.singleproject.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SingleProjectApplication.class)
@Slf4j
public class TestTag {
    @Autowired
    private TagService tagService;

    @Autowired
    private UserInfoService userInfoService;

    @Test
    public void testAddTag() {
        Tags tags = new Tags();
        tags.setTagName("测试中3。。");
        tags.setTagType(1);
        tagService.addTag(tags);
        System.out.println(JSON.toJSONString(tags));
    }

    @Test
    public void testRandomTag() {
        List<Tags> lsit = tagService.randomQueryTags(5, 1);
        System.out.println(JSON.toJSONString(lsit));
    }
}
