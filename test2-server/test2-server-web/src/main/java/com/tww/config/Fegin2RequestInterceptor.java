package com.tww.config;

import feign.Feign;
import feign.Request;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import feign.hystrix.HystrixFeign;
import org.springframework.cloud.openfeign.FeignClientsConfiguration;
import org.springframework.cloud.openfeign.FeignContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

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
