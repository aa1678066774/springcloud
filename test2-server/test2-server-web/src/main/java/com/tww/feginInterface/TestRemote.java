package com.tww.feginInterface;

import com.tww.rocketmq.config.FeginRequestInterceptor;
import com.tww.hystrix.TestHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Create by tangweiwei on 2019/5/5.
 */
@FeignClient(name= "spring-cloud-service1",fallback = TestHystrix.class,configuration = FeginRequestInterceptor.class)
public interface TestRemote {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String index(@RequestParam("name") String name);

    @RequestMapping(value = "/names", method = RequestMethod.GET)
    List<String> getList();
}
