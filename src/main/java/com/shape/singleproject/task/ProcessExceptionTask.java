package com.shape.singleproject.task;

import com.shape.singleproject.interceptor.TimeAop;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@Slf4j
@TimeAop
public class ProcessExceptionTask {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 5000)
    public void processDate() {
        log.info("now date: {}", dateFormat.format(new Date()));
    }
}
