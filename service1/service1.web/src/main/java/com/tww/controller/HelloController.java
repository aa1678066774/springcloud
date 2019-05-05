package com.tww.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create by tangweiwei on 2019/5/5.
 */
@RestController
public class HelloController {
	@RequestMapping("/hello")
	public String index(@RequestParam String name) {
		return "hello "+name+"，this is first messge";
	}
}
