package com.tww.feginInterface;

import com.tww.config.Fegin2RequestInterceptor;
import com.tww.hystrix.Test1Hystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @program: root
 * @description: fegin测试
 * @author: weiweiTang
 * @create: 2019-09-03 15:04
 */
@FeignClient(name= "file-service",fallback = Test1Hystrix.class,configuration = Fegin2RequestInterceptor.class)
public interface Test1Remote{
    @RequestMapping(value = "/start")
    public String index(@RequestParam("taskName") String taskName);
}
