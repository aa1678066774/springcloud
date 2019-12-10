package com.tww.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tww.model.User;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper extends BaseMapper<User> {

    @Select("select name from user")
    @ResultType(String.class)
    List<String> getUserName();
}
