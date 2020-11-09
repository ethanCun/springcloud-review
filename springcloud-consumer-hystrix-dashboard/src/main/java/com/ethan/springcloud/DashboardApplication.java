package com.ethan.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
//开启dashboard监控 默认页面localhost:9001/hystirx/
@EnableHystrixDashboard
public class DashboardApplication {

    public static void main(String[] args) {

        SpringApplication.run(DashboardApplication.class, args);
    }
}
