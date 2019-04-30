package com.tww;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Create by tangweiwei on 2019/4/30.
 */
@EnableDiscoveryClient
@SpringBootApplication
public class Service1Aplication {
	public static void main(String[] args) {
		SpringApplication.run(Service1Aplication.class, args);
	}
}
