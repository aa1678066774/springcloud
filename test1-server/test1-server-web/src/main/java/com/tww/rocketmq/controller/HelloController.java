package com.tww.rocketmq.controller;

import com.tww.fegin.HelloFeginService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * Create by tangweiwei on 2019/5/5.
 */
@RestController
public class HelloController implements HelloFeginService {

	@Override
	public String index(String name) {
		return "hello "+name+"，this is first messge";
	}

	@RequestMapping("/test")
	public String accpectDate(LocalDate date){
		return "this date is"+date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
	}

	@RequestMapping("/test1")
	public User accpectDate1(@RequestBody User user){
		return user;
	}


}

class User{
	private String name;

	private Date birthDay;

	private LocalDate date;

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}

	@Override
	public String toString() {
		return "User{" +
				"name='" + name + '\'' +
				", birthDay=" + birthDay +
				'}';
	}
}