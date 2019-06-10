package com.shape.singleproject;

import com.alibaba.fastjson.JSON;
import com.shape.singleproject.dto.Tags;
import com.shape.singleproject.service.TagService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StopWatch;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SingleProjectApplication.class)
@Slf4j
public class TagsServiceTest {

    @Resource
    private TagService tagService;


    @Test
    public void testRandomQueryTags() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        List<Tags> tags = tagService.randomQueryTags(2, 1);
        stopWatch.stop();
        log.error("tasg: {}, call:{}", JSON.toJSONString(tags), stopWatch.getTotalTimeSeconds());
    }
}
