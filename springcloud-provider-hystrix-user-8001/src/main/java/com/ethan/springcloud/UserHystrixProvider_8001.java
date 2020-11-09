package com.ethan.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 *
 * 服务熔断：
 *      某个服务挂了，采用另外的方法来处理，如使用另外一个方法处理；
 *
 * 服务降级：
 *      某个服务请求量大，资源不够用，将其他服务资源调整到当前请求数量大的服务，
 *      请求量正常后，在将其他服务恢复到它自己的状态；
 *
 */
@SpringBootApplication
@EnableEurekaClient //开启注册中心客户端
@EnableDiscoveryClient //支持服务发现
//添加对熔断(断路器)的支持
@EnableCircuitBreaker
public class UserHystrixProvider_8001 {

    public static void main(String[] args) {

        SpringApplication.run(UserHystrixProvider_8001.class);
    }

}
