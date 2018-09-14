package com.shape.singleproject.autoconfigure;

import com.shape.singleproject.interceptor.TimeAop;
import com.shape.singleproject.interceptor.TimeInterceptor;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.annotation.AnnotationMatchingPointcut;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@ConditionalOnProperty("spring.timeaop")
public class TimeAopAutoConfigure {

    @Bean
    public DefaultPointcutAdvisor timeAopAnnotationClassPointCut() {
        DefaultPointcutAdvisor advisor = new DefaultPointcutAdvisor();
        AnnotationMatchingPointcut pointcut = new AnnotationMatchingPointcut(TimeAop.class, true);
        TimeInterceptor interceptor = new TimeInterceptor();
        advisor.setPointcut(pointcut);
        advisor.setAdvice(interceptor);
        return advisor;
    }
}
