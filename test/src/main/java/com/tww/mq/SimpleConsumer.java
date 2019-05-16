package com.tww.mq;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

import java.io.IOException;

/**
 * Create by tangweiwei on 2019/5/15.
 */
public class SimpleConsumer extends DefaultConsumer {
	public SimpleConsumer(Channel channel) {
		super(channel);
	}

	@Override
	public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
		System.out.println(consumerTag);
		System.out.println("-----收到消息了---------------");
		System.out.println("消息属性为："+properties);
		System.out.println("消息内容为："+new String(body));
	}
}
