package com.tww.controller;

import com.tww.fegin.HelloFeginService;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create by tangweiwei on 2019/5/5.
 */
@RestController
public class HelloController implements HelloFeginService {

	@Override
	public String index(String name) {
		return "hello "+name+"，this is first messge";
	}
}
