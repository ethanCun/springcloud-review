package com.ethan.springcloud.controller;

import com.ethan.springcloud.pojo.User;
import com.ethan.springcloud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public boolean addUser(@RequestBody User user){

        return this.userService.addUser(user);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<User> userList(){

        return this.userService.userList();
    }

    @RequestMapping(value = "/selectById", method = RequestMethod.GET)
    public User userWithId(Integer id){

        return this.userService.userWithId(id);
    }

}
