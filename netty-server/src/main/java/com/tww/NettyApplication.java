package com.tww;

import com.tww.rocketmq.config.NettyServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @program: root
 * @description:
 * @author: weiweiTang
 * @create: 2019-08-06 17:54
 */
@SpringBootApplication
public class NettyApplication {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(NettyApplication.class, args);
        new NettyServer(12345).start();

    }
}
