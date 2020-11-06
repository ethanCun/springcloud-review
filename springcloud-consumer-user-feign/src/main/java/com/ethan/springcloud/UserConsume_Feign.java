package com.ethan.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient //开启eureka客户端
@EnableFeignClients(basePackages = {"com.ethan.springcloud"}) //开启Feign扫描宝
@ComponentScan(basePackages = {"com.ethan.springcloud"}) //扫描自己的包
public class UserConsume_Feign {

    public static void main(String[] args) {

        SpringApplication.run(UserConsume_Feign.class, args);
    }
}