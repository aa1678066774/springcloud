package com.tww.user.service.impl;

import com.tww.dao.UserDao;
import com.tww.model.User;
import com.tww.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Create by tangweiwei on 2019/5/9.
 */
@Service
public class UserServiceImpl  implements IUserService {

	@Autowired
	private UserDao userDao;

	@Override
	public List<User> selectAll() {
		return userDao.selectAll();
	}
}
