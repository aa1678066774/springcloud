package com.tww.controller;

import com.tww.feginInterface.TestRemote;
import com.tww.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create by tangweiwei on 2019/5/5.
 */
@RestController
public class TestController {
	@Autowired
	private TestRemote testRemote;

	@Autowired
	private IUserService userService;

	@RequestMapping("/test/{name}")
	public String index(@PathVariable String name) {
		System.out.println(testRemote.index(name));
//		List<User> list=userService.selectAll();
		Integer i=userService.insertUser(name);

		return "this is first messge! test "+name;
	}
}
