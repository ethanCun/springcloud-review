package com.ethan.springcloud.controller;

import com.ethan.springcloud.pojo.User;
import com.ethan.springcloud.service.UserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/hystrix")
public class UserController {

    @Autowired
    private UserService userService;

    @HystrixCommand(fallbackMethod = "hystrixUserWithId")
    @RequestMapping(value = "/user/{id}")
    public User userWithId(@PathVariable("id") Integer id){

        User user = this.userService.userWithId(id);

        if(user == null){

            throw new RuntimeException("不存在该客户");
        }



        return user;
    }


    public User hystrixUserWithId(@PathVariable("id") Integer id){

        return new User().setId(id).setName("没有对应的用户信息");
    }
}
