package com.tww.rocketmq.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @program: root
 * @description: 启动时执行
 * @author: weiweiTang
 * @create: 2019-08-27 15:11
 */
@Component
public class AskForLeave implements CommandLineRunner {

    Logger log = LoggerFactory.getLogger(AskForLeave.class);

    @Override
    public void run(String... args) throws Exception {
        askForLeave();
    }

    public void askForLeave(){
        log.info("项目启动了，执行了方法");
    }
}
