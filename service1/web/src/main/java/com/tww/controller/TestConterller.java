package com.tww.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create by tangweiwei on 2019/4/30.
 */
@RequestMapping("/test")
@RestController
public class TestConterller {

	@RequestMapping(value="/getStr/{str}",method=RequestMethod.GET)
	public String test(@PathVariable("str") String str){
		return str;
	}
}
