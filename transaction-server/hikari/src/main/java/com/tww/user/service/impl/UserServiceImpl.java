package com.tww.user.service.impl;

import com.tww.user.dao.UserDao;
import com.tww.user.entity.User;
import com.tww.user.entity.UserQuery;
import com.tww.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 操作相关
 */
@Service(UserService.BEAN_ID)
public class UserServiceImpl implements UserService {

	Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Resource(name=UserDao.BEAN_ID)
	private UserDao userDao;

	@Override
	public List<User> getUserList(UserQuery data) {
		// TODO Auto-generated method stub
		List<User> list=userDao.getUserList(data);
		System.out.println(list);
		return list;
	}


	@Override
	@Transactional
	public void insertUser(User data) {
		// TODO Auto-generated method stub
		userDao.insertUser(data);
//		int i=1/0;
//		User user= new User();
//		BeanUtils.copyProperties(data,user);
//		user.setName(data.getName()+"_copy");
//		userDao.insertUser(user);
	}

	@Override
	public void updateUser(User data) {
		// TODO Auto-generated method stub
		userDao.updateUser(data);
	}

	@Override
	public void deleteUser(User data) {
		// TODO Auto-generated method stub
		userDao.deleteUser(data);
	}

	@Override
	public void insertUserBranch(List<User> data) {
		// TODO Auto-generated method stub
		for(User user:data) {
			userDao.insertUser(user);
		}
	}

	@Override
	public void updateUserBranch(List<User> data) {
		// TODO Auto-generated method stub
		for(User user:data) {
			userDao.updateUser(user);
		}
	}

	@Override
	public void deleteUserBranch(List<User> data) {
		// TODO Auto-generated method stub
		for(User user:data) {
			userDao.deleteUser(user);
		}
	}

}
