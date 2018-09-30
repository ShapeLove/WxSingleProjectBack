package com.shape.singleproject.listener;

import com.shape.singleproject.event.ExceptEvent;
import com.shape.singleproject.interceptor.LogExceptAop;
import com.shape.singleproject.interceptor.TimeAop;
import com.shape.singleproject.service.EmailSendService;
import com.shape.singleproject.service.ExceptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Slf4j
@Async
public class CustomEventListener {

    @Autowired
    private ExceptService exceptService;

    @EventListener
    public void processExceptEvent(ExceptEvent exceptEvent) {
        exceptService.processExcept(exceptEvent.getMethodName(), exceptEvent.getExceptMessage());
    }
}
