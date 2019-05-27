package com.shape.singleproject.task;

import com.alibaba.fastjson.JSON;
import com.shape.singleproject.dto.ExceptInfo;
import com.shape.singleproject.interceptor.LogExceptAop;
import com.shape.singleproject.interceptor.TimeAop;
import com.shape.singleproject.service.EmailSendService;
import com.shape.singleproject.service.ExceptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.logging.LoggingSystem;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Slf4j
public class ProcessExceptionTask {

    @Autowired
    private ExceptService exceptService;

    @Autowired
    private EmailSendService emailSendService;

    // corn表达式 表示每10分钟执行一次
    @Scheduled(cron = "0 0/10 * * * ?")
    public void processExcept() {
        List<ExceptInfo> result = exceptService.queryOverTimeExcept();
        log.info("ProcessExceptionTask.processExcept result:{}, time:{}", JSON.toJSONString(result), LocalDateTime.now());
        if (!CollectionUtils.isEmpty(result)) {
            result.stream().forEach(exceptInfo -> emailSendService.sendEmail(exceptInfo));
        }
    }
}
