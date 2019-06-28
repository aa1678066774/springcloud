package com.tww.service;

import com.tww.channel.MqMessageSource;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;

/**
 * Create by tangweiwei on 2019/5/15.
 */
@EnableBinding(MqMessageSource.class)
public class MqMessageConsumer {
	@StreamListener(MqMessageSource.TEST_IN_PUT)
	public void messageInPut(Message<String> message) {
		System.err.println(" 消息接收成功：" + message.getPayload());
	}

}

