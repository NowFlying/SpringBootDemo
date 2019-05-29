package com.ggf.springboot.eventdemo.config;


import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.lang.Nullable;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/**
 * @Descripton 异步线程池的配置类
 * @Author: gqf
 * @create: 2019-05-28 21:29
 */
@EnableAsync
public class ListenerAsyncConfiguration implements AsyncConfigurer {


    @Nullable
    @Override
    public Executor getAsyncExecutor() {
        //使用Spring内置线程池任务对象
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        //设置线程池参数
        taskExecutor.setCorePoolSize(5);
        taskExecutor.setMaxPoolSize(10);
        taskExecutor.setQueueCapacity(25);
        taskExecutor.initialize();
        return taskExecutor;
    }

    @Nullable
    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return null;
    }
}
