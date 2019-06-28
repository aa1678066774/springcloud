package com.tww.hystrix;

import com.tww.feginInterface.TestRemote;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Create by tangweiwei on 2019/5/5.
 */
@Component
public class TestHystrix implements TestRemote {
	@Override
	public String index(@RequestParam("name") String name) {
		return "hello" +name+", this messge send failed";
	}
}
