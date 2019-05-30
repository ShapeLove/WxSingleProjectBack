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

    @EventListener
    public void processExceptEvent(ExceptEvent exceptEvent) {
        exceptService.processExcept(exceptEvent.getMethodName(), exceptEvent.getExceptMessage());
    }
}
