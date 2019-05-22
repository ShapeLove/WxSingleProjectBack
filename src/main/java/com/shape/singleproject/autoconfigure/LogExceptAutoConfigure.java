package com.shape.singleproject.autoconfigure;

import com.shape.singleproject.interceptor.LogExceptAop;
import com.shape.singleproject.interceptor.LogExceptInterceptor;
import com.shape.singleproject.interceptor.TimeAop;
import com.shape.singleproject.interceptor.TimeInterceptor;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.annotation.AnnotationMatchingPointcut;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

/**
 * 处理异常方法配置
 * 只有配置配有spring.enable.logexcept属性才开启处理异常方法
 */
@Configuration
@ConditionalOnProperty("shape.enable.logexcept")
public class LogExceptAutoConfigure {

    // 异常aop处理的类
    @Bean
    public LogExceptInterceptor logExceptInterceptor() {
        return new LogExceptInterceptor();
    }

    // 与异常aop的注解做绑定
    @Bean
    public DefaultPointcutAdvisor logExceptAnnotationClassPointCut() {
        DefaultPointcutAdvisor advisor = new DefaultPointcutAdvisor();
        AnnotationMatchingPointcut pointcut = new AnnotationMatchingPointcut(LogExceptAop.class, true);
        advisor.setPointcut(pointcut);
        advisor.setAdvice(logExceptInterceptor());
        return advisor;
    }
}
