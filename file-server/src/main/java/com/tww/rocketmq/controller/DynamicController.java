package com.tww.rocketmq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledFuture;

/**
 * @program: root
 * @description: 动态定时任务
 * @author: weiweiTang
 * @create: 2019-08-27 11:41
 */
@RestController
public class DynamicController {

    @Autowired
    private ThreadPoolTaskScheduler threadPoolTaskScheduler;

    @Resource(name = "scheduledFutures")
    private Map<String,ScheduledFuture<?>> scheduledFutures;

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD HH:mm:ss");

    private Runnable getTask(String taskName) {
        Runnable task = new Runnable() {
            @Override
            public void run() {
                System.out.println(taskName+"------at the time: " + dateFormat.format(new Date()));
            }
        };
        return task;
    }

    /**
     * 核心是利用ThreadPoolTaskScheduler的schedule()函数启动，返回一个ScheduledFeature。
     *
     * @return
     */
    @RequestMapping("/start")
    public String startTask(String taskName){
        /**
         * task:定时任务要执行的方法
         * trigger:定时任务执行的时间
         */
//        ScheduledFuture<?> scheduledFuture = threadPoolTaskScheduler.schedule(getTask(taskName), new CronTrigger("0/5 * * * * *") );
        Date date=new Date();
        Calendar cal=Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MINUTE,1);
        ScheduledFuture<?> scheduledFuture = threadPoolTaskScheduler.scheduleWithFixedDelay(getTask(taskName),cal.getTime(),30000);
        scheduledFutures.put(taskName,scheduledFuture);
        System.out.println("start task done");
        return "start task done";
    }


    @RequestMapping("/start1")
    public String startTask1(String taskName){
        /**
         * task:定时任务要执行的方法
         * trigger:定时任务执行的时间
         */
        ListenableFuture<String> future=threadPoolTaskScheduler.submitListenable(getCallable(taskName));
        future.addCallback(new ListenableFutureCallback<String>() {

            @Override
            public void onSuccess(String result) {
                //TODO
                System.out.println("success:"+result);
            }

            @Override
            public void onFailure(Throwable t) {
                // TODO Auto-generated method stub
                System.out.println("fail");
            }

        });
        System.out.println("start task done");
        return "start task done";
    }

    private Callable<String> getCallable(String taskName) {
        Callable<String> task = new Callable() {
            @Override
            public String call() throws Exception {
                return taskName+"aaa";
            }
        };
        return task;
    }
}
