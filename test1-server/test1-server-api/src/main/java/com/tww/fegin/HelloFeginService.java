package com.tww.fegin;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Create by tangweiwei on 2019/5/5.
 */
public interface HelloFeginService {
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String index(@RequestParam("name") String name);

	@RequestMapping(value = "/names", method = RequestMethod.GET)
	List<String> getList();
}
