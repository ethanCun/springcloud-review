package com.ethan.springcloud.controller;

import com.ethan.springcloud.pojo.User;
import com.ethan.springcloud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/selectById/{id}", method = RequestMethod.GET)
    public User userWithId(@PathVariable("id") Integer id){

        return this.userService.userWithId(id);
    }

    @Autowired
    private DiscoveryClient discoveryClient;

    //获取注册在eureka上的微服务信息, 用于展示微服务的具体信息
    @RequestMapping(value = "/getMiniServiceInfo")
    public DiscoveryClient getMiniServiceInfo(){

        //微服务清单
        List<String> serviceList = this.discoveryClient.getServices();
        System.out.println("serviceList: " + serviceList);

        //获取具体的微服务信息
        List<ServiceInstance> instances = this.discoveryClient.getInstances("springcloud-provider-user-8001");

        for (ServiceInstance instance : instances) {

            System.out.println(instance.getServiceId());
            System.out.println(instance.getHost());
            System.out.println(instance.getUri());
            System.out.println(instance.getPort());
        }

        return this.discoveryClient;
    }

}
