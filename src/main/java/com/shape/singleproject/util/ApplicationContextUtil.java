package com.shape.singleproject.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * 应用上下文工具类
 * 通过ApplicationContextAware接口接收spring生命周期回调并把初始化完成的上下文赋值到自己的静态变量中
 * 以此允许全局访问
 */
@Component
public class ApplicationContextUtil implements ApplicationContextAware {
    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ApplicationContextUtil.applicationContext = applicationContext;
    }

    public static <T> T getTargetBeanByType(Class<T> tClass) {
        return applicationContext.getBean(tClass);
    }
}
