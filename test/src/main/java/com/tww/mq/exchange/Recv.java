package com.tww.mq.exchange;

import com.rabbitmq.client.*;
import com.tww.mq.ConnectionUtil;

import java.io.IOException;

/**
 * Create by tangweiwei on 2019/5/15.
 */
public class Recv {
	private final static String QUEUE_NAME = "test_queue_work1";

	private final static String EXCHANGE_NAME = "test_exchange_fanout";

	public static void main(String[] argv) throws Exception {

		// 获取到连接以及mq通道
		Connection connection = ConnectionUtil.getConnection();
		Channel channel = connection.createChannel();

		// 声明队列
		channel.queueDeclare(QUEUE_NAME, false, false, false, null);

		// 绑定队列到交换机
		channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, "");

		// 同一时刻服务器只会发一条消息给消费者
		channel.basicQos(1);

		// 定义队列的消费者
		// 监听队列，手动返回完成
		channel.basicConsume(QUEUE_NAME, false, new DefaultConsumer(channel){
			@Override
			public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
				System.out.println(consumerTag);
				System.out.println("-----收到消息了---------------");
				System.out.println("消息内容为："+new String(body));
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				channel.basicAck(envelope.getDeliveryTag(), false);
			}
		});
	}

}
