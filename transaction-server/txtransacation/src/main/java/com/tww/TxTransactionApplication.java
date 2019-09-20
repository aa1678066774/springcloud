package com.tww;

import com.codingapi.txlcn.tc.config.EnableDistributedTransaction;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @program: root
 * @description:
 * @author: weiweiTang
 * @create: 2019-09-18 10:41
 */
@SpringBootApplication
@EnableFeignClients
@MapperScan("com.tww.**.dao")
@EnableDistributedTransaction
public class TxTransactionApplication {

    public static void main(String[] args) {
        SpringApplication.run(TxTransactionApplication.class, args);
    }

}
