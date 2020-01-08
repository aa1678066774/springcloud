package com.tww.rocketmq.config;

/**
 * @program: root
 * @description:
 * @author: weiweiTang
 * @create: 2019-12-25 17:48
 */
public class JmsConfig {


    public static final String NAME_SERVER = "127.0.0.1:9876";
    /**
     * 主题名称 主题一般是服务器设置好 而不能在代码里去新建topic（ 如果没有创建好，生产者往该主题发送消息 会报找不到topic错误）
     */
    public static final String TOPIC = "tww_test";
}
