package com.tww.user.service.impl;

import com.tww.dao.UserMapper;
import com.tww.model.User;
import com.tww.user.service.AsyncService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class AsyncServiceImpl implements AsyncService {

    private static final Logger logger = LoggerFactory.getLogger(AsyncServiceImpl.class);

    @Autowired
    private TaskExecutor taskExecutor;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    TestServiceImpl testServiceImpl;


    @Override
    @Transactional
    public void executeAsync(String name) {

        User user=new User();
        user.setName(name);
        user.setEmail("1678066774@QQ.COM");
        user.setAge(22);
        userMapper.insert(user);
        taskExecutor.execute(new Runnable() {

            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                testServiceImpl.math(name);
            }
        });

        User user1=new User();
        user1.setName(name+"1");
        user1.setEmail("123456789@QQ.COM");
        user1.setAge(22);
        userMapper.insert(user1);

    }


    @Transactional
    public void math(String name){
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
