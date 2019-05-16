package com.tww.mq;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * Create by tangweiwei on 2019/5/15.
 */
public class ConnectionUtil {
	public static Connection getConnection() throws Exception {
		//定义连接工厂
		ConnectionFactory factory = new ConnectionFactory();
		//设置服务地址
		factory.setHost("localhost");
		//端口
		factory.setPort(5672);
		//设置账号信息，用户名、密码、vhost
		factory.setVirtualHost("test");
		factory.setUsername("tangweiwei");
		factory.setPassword("12345678");
		// 通过工程获取连接
		Connection connection = factory.newConnection();
		return connection;
	}
}
