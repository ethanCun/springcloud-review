package com.ethan.springcloud.mapper;

import com.ethan.springcloud.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserDao {

    boolean addUser(User user);

    List<User> userList();

    User userWithId(Integer id);
}
