package com.shape.singleproject.autoconfigure;

import com.alibaba.fastjson.JSON;
import com.shape.singleproject.task.ProcessExceptionTask;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.scheduling.config.IntervalTask;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.config.Task;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

@Configuration
public class GlobalConfigure  {


    @Configuration
    @EnableScheduling
    @ConditionalOnProperty("shape.enable.scheul")
    public static class ScheulConfig {

        @Bean
        public ProcessExceptionTask processExceptionTask() {
            return new ProcessExceptionTask();
        }

    }


    @Configuration
    @EnableAsync
    @ConditionalOnProperty("shape.enable.async")
    public static class AsyncConfig{}

    @Bean
    public AsyncTaskExecutor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setThreadNamePrefix("Anno-Executor");
        executor.setMaxPoolSize(10);
        executor.setThreadPriority(Thread.MIN_PRIORITY);

        // 设置拒绝策略
        executor.setRejectedExecutionHandler(new RejectedExecutionHandler() {
            @Override
            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                // .....
            }
        });
        // 使用预定义的异常处理类
        // executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());

        return executor;
    }
}
