package com.shape.singleproject;

import com.shape.singleproject.dto.Tags;
import com.shape.singleproject.service.TagService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SingleProjectApplication.class)
@Slf4j
public class TestTag {

    @Autowired
    private TagService tagService;

    @Test
    public void testAddTag() {
        Tags tags = new Tags();
        tags.setTagName("测试中。。");
        tags.setTagType(1);
        tagService.addTag(tags);
    }
}
