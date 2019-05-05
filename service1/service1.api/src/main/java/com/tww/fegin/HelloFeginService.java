package com.tww.fegin;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Create by tangweiwei on 2019/5/5.
 */
public interface HelloFeginService {
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String index(@RequestParam("name") String name);
}
