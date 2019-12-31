package com.tww.rocketmq.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;

/**
 * @program: root
 * @description: Fegin配置
 * @author: weiweiTang
 * @create: 2019-09-03 14:46
 */
public class FeginRequestInterceptor implements RequestInterceptor{
    @Override
    public void apply(RequestTemplate template) {
        template.header("aaa","654321");
    }
}
