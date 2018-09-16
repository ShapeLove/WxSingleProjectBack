package com.shape.singleproject.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

@Slf4j
public class TimeInterceptor implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        long start = System.currentTimeMillis();
        log.info("time开始前");
        Object result = methodInvocation.proceed();
        if (log.isInfoEnabled()) {
            log.info("TiemInterceptorinvoke:{}.{} ellps:{} mills", methodInvocation.getThis().getClass().getCanonicalName(),
                    methodInvocation.getMethod().getName(),
                    (System.currentTimeMillis() - start));
        }
        return result;
    }
}
