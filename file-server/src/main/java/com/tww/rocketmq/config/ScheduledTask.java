package com.tww.rocketmq.config;

import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: root
 * @description: 定时任务
 * @author: weiweiTang
 * @create: 2019-08-27 11:16
 */
@Component
public class ScheduledTask {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD HH:mm:ss");

    //@Scheduled(fixedDelay = 5000)
    public void testFixRate() {
        System.out.println("我每隔5秒冒泡一次：" + dateFormat.format(new Date()));
    }
}
