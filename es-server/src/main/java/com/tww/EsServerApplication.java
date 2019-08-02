package com.tww;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

/**
 * @program: root
 * @description:
 * @author: weiweiTang
 * @create: 2019-07-16 16:04
 */
@SpringBootApplication
@EnableElasticsearchRepositories(basePackages = "com.tww.dao")
public class EsServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(EsServerApplication.class, args);
    }
}
