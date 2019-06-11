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

/**
 * 当存在shape.enable.timelog属性时切面生效
 */
@Configuration
@ConditionalOnProperty("shape.enable.timelog")
public class TimeAopAutoConfigure {

    /**
     * 因为性能记录拦截器没有特殊的逻辑所以不需要提前注入Spring中
     * @return
     */
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
