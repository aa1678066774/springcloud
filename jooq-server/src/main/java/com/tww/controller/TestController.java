package com.tww.controller;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

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
