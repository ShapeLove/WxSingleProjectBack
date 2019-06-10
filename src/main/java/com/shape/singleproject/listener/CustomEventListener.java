package com.shape.singleproject.listener;

import com.shape.singleproject.event.ExceptEvent;
import com.shape.singleproject.service.ExceptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
@Slf4j
@Async
public class CustomEventListener {

    @Resource
    private ExceptService exceptService;

    /**
     * 处理所有的异常
     * 记录异常的方法和异常信息到数据库
     * 用于定时任务每10分钟查询一次及时报警
     * @param exceptEvent
     */
    @EventListener
    public void processExceptEvent(ExceptEvent exceptEvent) {
        exceptService.processExcept(exceptEvent.getMethodName(), exceptEvent.getExceptMessage());
    }
}
