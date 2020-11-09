package com.ethan.springcloud.controller;

import com.ethan.springcloud.pojo.User;
import com.ethan.springcloud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/consume")
public class UserConsumeController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/userList")
    public List<User> userList(){

        return this.userService.userList();
    }

    @RequestMapping(value = "/userWithId/{id}")
    public User userList(@PathVariable("id") Integer id){

        //参数： url, 返回类型, 请求参数
        return this.userService.userWithId(id);
    }

    @RequestMapping(value = "/add")
    public boolean addUser(User user) throws Exception{

        return this.userService.addUser(user);
    }
}
