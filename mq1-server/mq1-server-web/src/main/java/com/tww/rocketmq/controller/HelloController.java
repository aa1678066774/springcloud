package com.tww.rocketmq.controller;

import com.tww.service.MqMessageProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create by tangweiwei on 2019/5/15.
 */
@RestController
public class HelloController {

	@Autowired
	MqMessageProducer mqMessageProducer;

	@RequestMapping("/hello/{name}")
	public String sayHello(	@PathVariable String name){
		mqMessageProducer.sendMsg(name);
		return "hello,"+name;
	}
}
