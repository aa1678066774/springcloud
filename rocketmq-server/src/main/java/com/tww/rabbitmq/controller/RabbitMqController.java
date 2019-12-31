package com.tww.rabbitmq.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: root
 * @description:
 * @author: weiweiTang
 * @create: 2019-12-31 11:40
 */
@Slf4j
@RestController
public class RabbitMqController {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    @RequestMapping("/test/rabbitmq")
    public void test(String str){
        rabbitTemplate.convertAndSend("hello",str);
//        rabbitTemplate.convertAndSend("spring.direct.exchange","A",str);

        log.info("已发送消息："+str);
    }
}
