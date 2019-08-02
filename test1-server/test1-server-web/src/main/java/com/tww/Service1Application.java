package com.tww;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Create by tangweiwei on 2019/5/5.
 */
@SpringBootApplication
//从Spring Cloud Edgware开始，@EnableDiscoveryClient 或@EnableEurekaClient 可省略。只需加上相关依赖，并进行相应配置，即可将微服务注册到服务发现组件上。
//@EnableDiscoveryClient
public class Service1Application {
	public static void main(String[] args) {
		SpringApplication.run(Service1Application.class, args);
	}
}
