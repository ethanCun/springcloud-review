package com.ethan.springcloud.service;

import com.ethan.springcloud.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

//feign: 可以被服务直接调用, 面向接口，和Ribbon不一样不需要通过写微服务名称调用
//value: 微服务名字
@Component
@FeignClient(value = "SPRINGCLOUD-PROVIDER-USER")
public interface UserService {

    //value是服务提供者的方法
    @GetMapping(value = "/user/list")
    List<User> userList();

    @GetMapping(value = "/user/selectById/{id}")
    User userWithId(@PathVariable("id") int id);

    @PostMapping(value = "/user/add")
    boolean addUser(@RequestBody User user);
}
