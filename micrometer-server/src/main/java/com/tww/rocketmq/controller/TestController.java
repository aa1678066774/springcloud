package com.tww.rocketmq.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: root
 * @description:
 * @author: weiweiTang
 * @create: 2019-11-01 17:12
 */
@RestController
public class TestController {

    @GetMapping("/test")
    public String test(@RequestParam("name") String name){
        return "test:"+name;
    }
}
