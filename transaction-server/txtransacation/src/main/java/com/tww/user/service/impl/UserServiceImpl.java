package com.tww.user.service.impl;

import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.tww.user.dao.UserDao;
import com.tww.user.entity.User;
import com.tww.user.entity.UserQuery;
import com.tww.user.fegin.UserFegin;
import com.tww.user.service.UserService;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 操作相关
 */
@Service(UserService.BEAN_ID)
public class UserServiceImpl implements UserService {

	Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Resource(name=UserDao.BEAN_ID)
	private UserDao userDao;

	@Autowired
	private SqlSessionFactory factory;

	@Autowired
	private UserFegin userFegin;

	/**
	 * Isolation.READ_UNCOMMITTED 最低的隔离级别，允许读取尚未提交的数据变更，可能会导致脏读、幻读或不可重复读
	 * Isolation.READ_COMMITTED 允许读取并发事务已经提交的数据，可以阻止脏读，但是幻读或不可重复读仍有可能发生
	 * Isolation.REPEATABLE_READ 对同一字段的多次读取结果都是一致的，除非数据是被本身事务自己所修改，可以阻止脏读和不可重复读，但幻读仍有可能发生(幻读理解查看博客)
	 * Isolation.SERIALIZABLE 最高的隔离级别，完全服从ACID的隔离级别，确保阻止脏读、不可重复读以及幻读，也是最慢的事务隔离级别，因为它通常是通过完全锁定事务相关的数据库表来实现的
	 * @param data
	 * @return的
	 */
	@Override
	@Transactional(isolation = Isolation.REPEATABLE_READ)
	public List<User> getUserList(UserQuery data) {
		// TODO Auto-generated method stub
		List<User> list=new ArrayList<>();
		list=userDao.getUserList(data);
		System.out.println(list);
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//获取sqlsession并清除一级缓存
		SqlSessionUtils.getSqlSession(factory).clearCache();
		list=userDao.getUserList(data);
		System.out.println(list);
		return list;
	}

	/**
	 * Propagation.REQUIRED 如果存在一个事务，则支持当前事务。如果没有事务则开启一个新的事务。
	 * Propagation.SUPPORTS 如果存在一个事务，支持当前事务。如果没有事务，则非事务的执行
	 * Propagation.MANDATORY 如果已经存在一个事务，支持当前事务。如果没有一个活动的事务，则抛出异常(No existing transaction found for transaction marked with propagation 'mandatory')
	 * Propagation.REQUIRES_NEW 总是开启一个新的事务。如果一个事务已经存在，则将这个存在的事务挂起。
	 * Propagation.NOT_SUPPORTED 总是非事务地执行，并挂起任何存在的事务
	 * Propagation.NEVER 总是非事务地执行，如果存在一个活动事务，则抛出异常。
	 *
	 * @param data
	 */
//	@Override
//	@Transactional(propagation= Propagation.NEVER)
//	public void insertUser(User data) {
//		// TODO Auto-generated method stub
//		userDao.insertUser(data);
//        int i=1/0;
//		User user= new User();
//		BeanUtils.copyProperties(data,user);
//		user.setName(data.getName()+"_copy");
//		userDao.insertUser(user);
//	}


	@Override
	@LcnTransaction
	@Transactional
	public void insertUser(User data) {
		// TODO Auto-generated method stub
		userDao.insertUser(data);

		userFegin.index(data);
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
