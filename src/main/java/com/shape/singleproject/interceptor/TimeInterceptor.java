package com.shape.singleproject.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

@Slf4j
public class TimeInterceptor implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        long start = System.currentTimeMillis();
        log.warn("TimeInterceptor start thread:{} invoke:{}.{} ", Thread.currentThread().getName(),
                methodInvocation.getThis().getClass().getCanonicalName(),
                methodInvocation.getMethod().getName(),
                (System.currentTimeMillis() - start));
        Object result = methodInvocation.proceed();
        if (log.isWarnEnabled()) {
            log.warn("TimeInterceptor end thread:{} invoke:{}.{} ellps:{} mills", Thread.currentThread().getName(), methodInvocation.getThis().getClass().getCanonicalName(),
                    methodInvocation.getMethod().getName(),
                    (System.currentTimeMillis() - start));
        }
        return result;
    }
}
