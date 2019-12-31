package com.tww.rocketmq.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: root
 * @descript:
 * @author: weiweiTang
 * @create: 2019-08-06 18:05
 */
@Controller
public class DefaultController {
    @RequestMapping("/index")
    public String index(){
        return "index";
    }
}
