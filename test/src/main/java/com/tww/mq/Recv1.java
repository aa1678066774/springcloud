package com.tww.mq;

import com.rabbitmq.client.*;

import java.io.IOException;

/**
 * Create by tangweiwei on 2019/5/15.
 */
public class Recv1 {
	private final static String QUEUE_NAME = "q_test_01";

	public static void main(String[] argv) throws Exception {

		// 获取到连接以及mq通道
		Connection connection = ConnectionUtil.getConnection();
		// 从连接中创建通道
		Channel channel = connection.createChannel();

		channel.basicQos(1);
		// 声明队列
		channel.queueDeclare(QUEUE_NAME, false, false, false, null);

		// 监听队列
		channel.basicConsume(QUEUE_NAME, false, new DefaultConsumer(channel){
			@Override
			public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
				System.out.println(consumerTag);
				System.out.println("-----收到消息了---------------");
				System.out.println("消息内容为："+new String(body));
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				channel.basicAck(envelope.getDeliveryTag(), false);
			}
		});
	}
}
