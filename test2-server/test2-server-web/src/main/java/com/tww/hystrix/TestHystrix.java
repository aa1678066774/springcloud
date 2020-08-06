package com.tww.hystrix;

import com.tww.feginInterface.TestRemote;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Create by tangweiwei on 2019/5/5.
 */
@Component
public class TestHystrix implements TestRemote {
	@Override
	public String index(@RequestParam("name") String name) {
		return "hello" +name+", this messge send failed";
	}

	@Override
	public List<String> getList() {
		System.out.println("getList 服务降级");
		return null;
	}
}
