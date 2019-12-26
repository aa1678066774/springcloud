package com.tww.controller;

import com.tww.config.JmsConfig;
import com.tww.producer.Producer;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: root
 * @description:
 * @author: weiweiTang
 * @create: 2019-12-25 17:56
 */
@Slf4j
@RestController
public class TestController {

    @Autowired
    private Producer producer;

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    @RequestMapping("/text/rocketmq")
    public Object callback(String str) throws Exception {
//        List<String> mesList = new ArrayList<>();
//        mesList.add("小小");
//        mesList.add("爸爸");
//        mesList.add("妈妈");
//        mesList.add("爷爷");
//        mesList.add("奶奶");
//        //总共发送五次消息
//        for (String s : mesList) {
//            //创建生产信息
//            Message message = new Message(JmsConfig.TOPIC, "testtag", ("小小一家人的称谓:" + s).getBytes());
//            //发送
//            SendResult sendResult = producer.getProducer().send(message);
//            log.info("输出生产者信息={}",sendResult);
//        }
        //创建生产信息
//        Message message = new Message(JmsConfig.TOPIC, "testtag", ("字符串:" + str).getBytes());
//        //发送
//        SendResult sendResult = producer.getProducer().send(message);
//        log.info("输出生产者信息={}",sendResult);

        rocketMQTemplate.convertAndSend(JmsConfig.TOPIC,"消息:"+str);

        return "成功";
    }
}
