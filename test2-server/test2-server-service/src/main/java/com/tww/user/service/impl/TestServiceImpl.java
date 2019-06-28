package com.tww.user.service.impl;

import com.tww.dao.UserMapper;
import com.tww.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TestServiceImpl {

    private static final Logger logger = LoggerFactory.getLogger(TestServiceImpl.class);

    @Autowired
    private UserMapper userMapper;

    @Transactional
    public void math(String name) {
        User user2=new User();
        user2.setName(name+"2");
        user2.setEmail("123456789@QQ.COM");
        user2.setAge(22);
        userMapper.insert(user2);
        int j=1/0;
        User user3=new User();
        user3.setName(name+"3");
        user3.setEmail("123456789@QQ.COM");
        user3.setAge(22);
        userMapper.insert(user3);
        List<User> users=userMapper.selectList(null);
        logger.info(users.toString());
    }
}
