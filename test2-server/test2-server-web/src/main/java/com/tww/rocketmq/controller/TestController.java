package com.tww.rocketmq.controller;

import com.tww.feginInterface.Test1Remote;
import com.tww.feginInterface.TestRemote;
import com.tww.model.User;
import com.tww.user.service.AsyncService;
import com.tww.user.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Create by tangweiwei on 2019/5/5.
 */
@RestController
public class TestController {

	private static final Logger logger = LoggerFactory.getLogger(TestController.class);

	@Autowired
	private TestRemote testRemote;

	@Autowired
	private Test1Remote test1Remote;

	@Autowired
	private IUserService userService;

	@Autowired
	private AsyncService asyncService;

	@RequestMapping("/test/{name}")
	public String index(@PathVariable String name) {
//		System.out.println(testRemote.index(name));
//		System.out.println(test1Remote.index(name));
		long start =System.currentTimeMillis();
		List<String> names=testRemote.getList();
		long end =System.currentTimeMillis();
		System.out.println("fegin 耗时:"+(end-start));
		return "this is first messge! test "+name;
	}
//
//	@RequestMapping(value = "/getUserList",produces = "application/json")
//	public List<User> getUserList() {
//		List<User> list=userService.selectAll();
//		return list;
//	}
//
//	@RequestMapping("/testThreadPool")
//	public String submit(String name){
//		logger.info("start submit");
//
//		//调用service层的任务
//		asyncService.executeAsync(name);
//
//		logger.info("end submit");
//
//		return "success";
//	}


}
