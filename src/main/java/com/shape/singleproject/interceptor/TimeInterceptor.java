package com.shape.singleproject.interceptor;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class TimeInterceptor implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = methodInvocation.proceed();
        System.out.println("调用:" + methodInvocation.getClass().getName() + "." + methodInvocation.getMethod().getName() + "  共花费 " + (System.currentTimeMillis() - start) + "毫秒");
        return result;
    }
}
