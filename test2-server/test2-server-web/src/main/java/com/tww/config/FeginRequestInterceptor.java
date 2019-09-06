package com.tww.config;

import feign.Feign;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import feign.hystrix.HystrixFeign;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;

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
