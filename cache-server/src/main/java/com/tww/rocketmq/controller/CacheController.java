package com.tww.rocketmq.controller;

import com.tww.model.Customer;
import com.tww.model.User;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: root
 * @description:
 * @author: weiweiTang
 * @create: 2019-12-16 14:10
 */
@RestController
@RequestMapping("cache")
public class CacheController {
    @RequestMapping(value = "listCustomers",produces = "application/json")
    @Cacheable( value = "listCustomers" , key = "#length", sync = true)
    @ResponseBody
    public List<Customer> listCustomers(Long length){
        List<Customer> customers = new ArrayList<>();
        for(int i=1; i <= length ; i ++){
            Customer customer = new Customer(i, "zhuyu"+i, 20 + i, false);
            customers.add(customer);
        }
        return customers;
    }

    // 以第一个参数为key进行缓存
    @Cacheable(value="users", key="#p0")
    public Long find(Long id) {
        return id;
    }
    // 以User中的id值为key进行缓存
    @Cacheable(value="users", key="#user.id")
    public User find(User user) {
        return user;
    }
    // 以User中的id值为key，且 condition 条件满足则缓存
//    @Cacheable(value="users", key="#user.id", condition="#user.id%2==0")
//    public User find(User user) {
//        return user;
//    }
}
