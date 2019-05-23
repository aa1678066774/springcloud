package com.tww.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tww.model.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * Create by tangweiwei on 2019/5/9.
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
