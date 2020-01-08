package com.tww.kafka.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @program: root
 * @description:
 * @author: weiweiTang
 * @create: 2020-01-06 14:35
 */
@Component
public class ConsumerListener {

    @KafkaListener(topics = "testTopic")
    public void onMessage(String message){
        //insertIntoDb(buffer);//这里为插入数据库代码
        System.out.println("message: " + message);
    }

}
