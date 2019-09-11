package com.tww;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @program: root
 * @description: spring boot main
 * @author: weiweiTang
 * @create: 2019-09-11 14:02
 */
@SpringBootApplication
@MapperScan("com.tww.**.dao")
public class Transaction1Application {
    public static void main(String[] args) {
        SpringApplication.run(Transaction1Application.class, args);
    }
}
