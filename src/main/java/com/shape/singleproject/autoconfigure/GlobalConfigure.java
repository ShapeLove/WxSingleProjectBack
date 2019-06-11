package com.shape.singleproject.autoconfigure;

import com.shape.singleproject.task.ProcessExceptionTask;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 全局配置
 */

@Configuration
public class GlobalConfigure  {


    /**
     * 定时任务配置
     * 只有配置文件中有shape.enable.schedul配置才能够启动定时任务
     */
    @Configuration
    @EnableScheduling
    @ConditionalOnProperty("shape.enable.schedul")
    public static class ScheulConfig {

        /**
         * 扫描异常信息定时任务
         * @return
         */
        @Bean
        public ProcessExceptionTask processExceptionTask() {
            return new ProcessExceptionTask();
        }

    }


    /**
     * 异步处理配置
     * 只有配置中有shape.enable.async才启动异步处理
     */
    @Configuration
    @EnableAsync
    @ConditionalOnProperty("shape.enable.async")
    public static class AsyncConfig{

        /**
         * 配置异步处理线程池
         * 也就是说所有带有@Async注解的类 需要异步处理的话 都是该线程池来处理
         * @return
         */
        @Bean
        public AsyncTaskExecutor taskExecutor() {
            ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
            executor.setThreadNamePrefix("Anno-Executor");
            executor.setMaxPoolSize(10); //最多同时处理十条任务
            // 异步处理为最低优先级
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
}
