package com.ethan.springcloud.service.imp;

import com.ethan.springcloud.mapper.UserDao;
import com.ethan.springcloud.pojo.User;
import com.ethan.springcloud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public boolean addUser(User user) {
        return this.userDao.addUser(user);
    }

    public List<User> userList() {
        return this.userDao.userList();
    }

    public User userWithId(Integer id) {
        return this.userDao.userWithId(id);
    }
}
