package com.ethan.springcloud.controller;

import com.ethan.springcloud.pojo.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping(value = "/consume")
public class UserConsumeController {

    //消费者不应该有service层 restTemplate: 简单的restful模板
    @Autowired
    private RestTemplate restTemplate;

    //Ribbon： 通过服务名称去访问 注意是大写 应用名称必须大写
    public static final String REST_URL_PREFIX="http://SPRINGCLOUD-PROVIDER-USER";


    @RequestMapping(value = "/userList")
    public List<User> userList(){

        return this.restTemplate.getForObject(REST_URL_PREFIX+"/user/list", List.class);
    }

    @RequestMapping(value = "/userWithId/{id}")
    public User userList(@PathVariable("id") Integer id){

        //参数： url, 返回类型, 请求参数
        return this.restTemplate.getForObject(REST_URL_PREFIX+"/user/selectById?id="+id, User.class);
    }

    @RequestMapping(value = "/add")
    public boolean addUser(User user) throws Exception{

        return this.restTemplate.postForObject(REST_URL_PREFIX+"/user/add", user, Boolean.class);
    }
}
