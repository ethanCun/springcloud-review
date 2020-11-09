package com.ethan.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer //开启springcloud config
public class ConfigServerApplication_3344 {

    public static void main(String[] args) {

        SpringApplication.run(ConfigServerApplication_3344.class, args);
    }
}
