package com.tww.rocketmq.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledFuture;

/**
 * @program: root
 * @description: 定时任务配置
 * @author: weiweiTang
 * @create: 2019-08-27 14:26
 */
@Configuration
public class ScheduleConfig {

    @Bean
    public ThreadPoolTaskScheduler getThreadPoolTaskScheduler(){
        return new ThreadPoolTaskScheduler();
    }
    @Bean("scheduledFutures")
    public Map<String, ScheduledFuture<?>> getScheduledFutures(){
        return new ConcurrentHashMap<>();
    }
}
