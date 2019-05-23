package com.tww.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tww.model.User;

import java.util.List;

/**
 * Create by tangweiwei on 2019/5/9.
 */
public interface IUserService extends IService<User> {

	public List<User> selectAll();

	public Integer insertUser(String name);
}
