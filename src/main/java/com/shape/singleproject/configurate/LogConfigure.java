package com.shape.singleproject.configurate;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.BeansException;
import org.springframework.boot.actuate.logging.LoggersEndpoint;
import org.springframework.boot.logging.LogLevel;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class LogConfigure implements ApplicationContextAware {
    private ApplicationContext applicationContext;

    public static LoggersEndpoint loggersEndpoint;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
        loggersEndpoint = (LoggersEndpoint)this.applicationContext.getBean("loggersEndpoint");
    }

}
