package com.tww;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @program: root
 * @description:
 * @author: weiweiTang
 * @create: 2019-12-04 14:47
 */
@SpringBootApplication
@MapperScan("com.tww.**.mapper")
public class MybatisApplication {
    public static void main(String[] args) {
        SpringApplication.run(MybatisApplication.class, args);
    }
}
