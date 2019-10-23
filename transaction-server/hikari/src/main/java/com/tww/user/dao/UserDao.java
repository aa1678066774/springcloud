package com.tww.user.dao;

import com.tww.user.entity.User;
import com.tww.user.entity.UserQuery;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * 操作相关
 */
public interface UserDao {

	public final static String BEAN_ID = "userDao";

	public List<User> getUserList(UserQuery data);

	public void insertUser(User data);

	public void updateUser(User data);

	public void deleteUser(User data);

	@Update("update user set name=#{a} where id=1")
	void updateUserName(@Param("a") String a);
}
