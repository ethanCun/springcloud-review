package com.ethan.springcloud;

import com.ethan.rule.MyRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableEurekaClient //开启eureka客户端
//开启Ribbon客户端负载均衡，定义负载均衡算法
@RibbonClient(name = "SPRINGCLOUD-PROVIDER-USER", configuration = MyRule.class)
public class UserConsume_80 {

    public static void main(String[] args) {

        SpringApplication.run(UserConsume_80.class, args);
    }
}
