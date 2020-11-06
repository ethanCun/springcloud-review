package com.ethan.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient //开启eureka注册提供者，在服务启动后自动注册到eureka中
@EnableDiscoveryClient //服务发现,可以通过DiscoveryClient获取微服务信息
public class UserProvider_8001 {

    public static void main(String[] args) {

        SpringApplication.run(UserProvider_8001.class, args);
    }
}
