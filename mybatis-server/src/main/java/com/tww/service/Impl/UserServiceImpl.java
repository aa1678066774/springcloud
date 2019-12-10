package com.tww.service.Impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.tww.mapper.UserMapper;
import com.tww.model.User;
import com.tww.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: root
 * @description:
 * @author: weiweiTang
 * @create: 2019-12-05 10:51
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    public List<User> getList(){
        return userMapper.selectList(null);
    }

    @DS("test1")
    public List<String> getUserName(){
        return userMapper.getUserName();
    }
}
