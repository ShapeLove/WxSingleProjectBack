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

@Configuration
@ConditionalOnProperty("spring.customlog")
public class LogExceptAutoConfigure {

    @Bean
    public LogExceptInterceptor logExceptInterceptor() {
        return new LogExceptInterceptor();
    }

    @Bean
    public DefaultPointcutAdvisor logExceptAnnotationClassPointCut() {
        DefaultPointcutAdvisor advisor = new DefaultPointcutAdvisor();
        AnnotationMatchingPointcut pointcut = new AnnotationMatchingPointcut(LogExceptAop.class, true);
        advisor.setPointcut(pointcut);
        advisor.setAdvice(logExceptInterceptor());
        return advisor;
    }
}
