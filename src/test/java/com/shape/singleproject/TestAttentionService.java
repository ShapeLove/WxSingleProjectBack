package com.shape.singleproject;

import com.shape.singleproject.dto.AttentionInfo;
import com.shape.singleproject.service.AttentionService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SingleProjectApplication.class)
@Slf4j
public class TestAttentionService {

    @Autowired
    private AttentionService attentionService;

    @Test
    public void testAttention() {
        AttentionInfo attentionInfo = AttentionInfo.Build()
                .attentionOpenid("kjdigujk2341414")
                .toAttentionOpenid("geryerywer123124")
                .build();
    }
}
