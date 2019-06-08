package com.shape.singleproject.controller;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.shape.singleproject.dto.AttentionInfo;
import com.shape.singleproject.service.AttentionService;
import com.shape.singleproject.util.WebUtil;
import com.shape.singleproject.vo.AttentionInfoVo;
import com.shape.singleproject.vo.AttentionQuery;
import com.shape.singleproject.vo.PageResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

//小程序端的關注接口
@RestController
@RequestMapping("/attention")
@Slf4j
public class AttentionController {

    @Resource
    private AttentionService attentionService;

    @PostMapping("/list")
    public List<AttentionInfoVo> listAttentionInfo(@RequestBody AttentionQuery query) {
        try {
            String openId = WebUtil.getCurrentUserOpenId();
            if (!StringUtils.isEmpty(query.getToAttentionOpenId())) {
                query.setToAttentionOpenId(openId);
            }

            if (!StringUtils.isEmpty(query.getAttentionOpenId())) {
                query.setAttentionOpenId(openId);
            }

            return attentionService.queryAttentionByPage(query);
        }catch (Exception e) {
            log.error("AttentionController.listAttentionInfo error query:{}", JSON.toJSONString(query), e);
            return Lists.newArrayList();
        }
    }
}
