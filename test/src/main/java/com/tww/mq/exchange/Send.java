package com.tww.mq.exchange;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.tww.mq.ConnectionUtil;

/**
 * Create by tangweiwei on 2019/5/15.
 */
public class Send {
	private final static String EXCHANGE_NAME = "test_exchange_fanout";

	public static void main(String[] argv) throws Exception {
		// 获取到连接以及mq通道
		Connection connection = ConnectionUtil.getConnection();
		Channel channel = connection.createChannel();

		// 声明exchange
		channel.exchangeDeclare(EXCHANGE_NAME, "fanout");

		// 消息内容
		String message = "Hello World!";
		channel.basicPublish(EXCHANGE_NAME, "", null, message.getBytes());
		System.out.println(" [x] Sent '" + message + "'");

		channel.close();
		connection.close();
	}
}
