package com.tww.dao;

import com.tww.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Create by tangweiwei on 2019/5/9.
 */
@Mapper
public interface UserDao {
	@Select("select * from user")
	List<User> selectAll();
}
