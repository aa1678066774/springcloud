package com.tww.service;

import com.tww.model.User;

import java.util.List;

public interface UserService {

    List<User> getList();

    List<String> getUserName();
}
