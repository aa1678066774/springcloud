package com.tww.rocketmq.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;

/**
 * @program: root
 * @description:
 * @author: weiweiTang
 * @create: 2019-09-03 15:06
 */
public class Fegin2RequestInterceptor implements RequestInterceptor{
    @Override
    public void apply(RequestTemplate template) {
        template.header("token","123456");
    }
}
