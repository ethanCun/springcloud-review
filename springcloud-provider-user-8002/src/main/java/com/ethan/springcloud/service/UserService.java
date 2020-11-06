package com.ethan.springcloud.service;

import com.ethan.springcloud.pojo.User;

import java.util.List;

public interface UserService {

    boolean addUser(User user);

    List<User> userList();

    User userWithId(Integer id);
}
