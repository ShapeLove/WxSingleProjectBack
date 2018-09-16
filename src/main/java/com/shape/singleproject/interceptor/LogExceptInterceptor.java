package com.shape.singleproject.interceptor;

import com.alibaba.fastjson.JSON;
import com.shape.singleproject.event.ExceptEvent;
import com.shape.singleproject.service.ExceptService;
import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Slf4j
public class LogExceptInterceptor implements MethodInterceptor,ApplicationEventPublisherAware {


    private ApplicationEventPublisher applicationEventPublisher;



    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        if (log.isDebugEnabled()) {
            log.debug("LogExcept Info classAndmethod:{}#{}, param:{}", methodInvocation.getThis().getClass().getCanonicalName(),
                    methodInvocation.getMethod().getName(),
                    JSON.toJSONString(methodInvocation.getArguments()));
        }
        Object result;
        try {
            result = methodInvocation.proceed();
        } catch (Throwable throwable) {
            String methodName =  methodInvocation.getThis().getClass().getCanonicalName() + "#" + methodInvocation.getMethod().getName();
            log.error("LogExcept Info classAndmethod:{}, param:{}", methodName,
                    JSON.toJSONString(methodInvocation.getArguments()), throwable);
            applicationEventPublisher.publishEvent(new ExceptEvent(methodName, throwable.getMessage()));
            throw throwable;
        }

        if (log.isDebugEnabled()) {
            log.debug("LogExcept Info classAndmethod:{}#{}, result:{}", methodInvocation.getThis().getClass().getCanonicalName(),
                    methodInvocation.getMethod().getName(),
                    JSON.toJSONString(result));
        }

        return result;
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }
}
