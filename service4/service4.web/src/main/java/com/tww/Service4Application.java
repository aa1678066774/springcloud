package com.tww;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Create by tangweiwei on 2019/5/15.
 */
@SpringBootApplication
@EnableDiscoveryClient
public class Service4Application {
	public static void main(String[] args) {
		SpringApplication.run(Service4Application.class, args);
	}
}
