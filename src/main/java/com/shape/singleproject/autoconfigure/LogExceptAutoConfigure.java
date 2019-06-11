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

    /**
     * 异常日志记录与处理拦截器注入到Spring中
     * 如果不注入其中的实现的spring生命周期回调方法将不会生效
     * @return
     */
    @Bean
    public LogExceptInterceptor logExceptInterceptor() {
        return new LogExceptInterceptor();
    }

    /**
     * 创建切面点
     * 把自定义的切面注解与处理逻辑进行绑定并放入Spring中
     * @Bean注解表示注入到Spring容器中进行管理
     * @return
     */
    @Bean
    public DefaultPointcutAdvisor logExceptAnnotationClassPointCut() {
        DefaultPointcutAdvisor advisor = new DefaultPointcutAdvisor();
        AnnotationMatchingPointcut pointcut = new AnnotationMatchingPointcut(LogExceptAop.class, true);
        advisor.setPointcut(pointcut);
        advisor.setAdvice(logExceptInterceptor());
        return advisor;
    }
}
