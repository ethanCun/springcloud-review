package com.ethan.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy //开启路由网关代理
public class Zuul_Application_9527 {

    public static void main(String[] args) {

        SpringApplication.run(Zuul_Application_9527.class, args);
    }
}
