package com.tww.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tww.dao.UserMapper;
import com.tww.model.User;
import com.tww.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Create by tangweiwei on 2019/5/9.
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

	@Autowired
	private UserMapper userMapper;

	@Override
	public List<User> selectAll() {

		return userMapper.selectList(null);
	}

	@Override
	public Integer insertUser(String name) {
		User user=new User();
		return userMapper.insert(user);
	}
}
