package com.tww;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @program: root
 * @description: hikari test
 * @author: weiweiTang
 * @create: 2019-10-18 09:30
 */
@SpringBootApplication
@MapperScan("com.tww.**.dao")
public class HikariApplication {
    public static void main(String[] args) {
        SpringApplication.run(HikariApplication.class, args);
    }
}
