package com.tww.user.service;

import java.util.List;
import com.tww.user.entity.User;
import com.tww.user.entity.UserQuery;

/**
 * 操作相关
 */
public interface UserService {
	
	public final static String BEAN_ID="userService";
	
	List<User> getUserList(UserQuery data);

	void insertUser(User data);

	void updateUser(User data);

	void deleteUser(User data);
	
	void insertUserBranch(List<User> data);

	void updateUserBranch(List<User> data);

	void deleteUserBranch(List<User> data);

}
