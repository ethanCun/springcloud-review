package com.ethan.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer// 开启eureka服务器, 启动之后访问localhost:7001
public class EurekaServer_7001 {

    public static void main(String[] args) {

        SpringApplication.run(EurekaServer_7001.class, args);
    }
}
