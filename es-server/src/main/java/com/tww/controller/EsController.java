package com.tww.controller;

import com.tww.dao.UserReposiory;
import com.tww.model.UserEntity;
import org.elasticsearch.client.transport.TransportClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * @program: root
 * @description:
 * @author: weiweiTang
 * @create: 2019-07-30 16:25
 */
@RestController
public class EsController {

    @Autowired
    private UserReposiory userReposiory;

    @Autowired
    private TransportClient client;

    @RequestMapping("/addUser")
    public UserEntity addUser(@RequestBody UserEntity user) {
        return userReposiory.save(user);
    }

    @RequestMapping("/findUser")
    public Optional<UserEntity> findUser(String id) {
        return userReposiory.findById(id);
    }

    @RequestMapping("/findAll")
    public Iterable<UserEntity> findAll() {
        return userReposiory.findAll(PageRequest.of(0,2,new Sort(Sort.Direction.DESC,"age")));
    }

}
