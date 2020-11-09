package com.ethan.springcloud;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient //开启eureka注册提供者，在服务启动后自动注册到eureka中
@EnableDiscoveryClient //服务发现,可以通过DiscoveryClient获取微服务信息
public class UserProvider_8001 {

    public static void main(String[] args) {

        SpringApplication.run(UserProvider_8001.class, args);
    }

    //增加一个dashboard监控servlet
    @Bean
    public ServletRegistrationBean servletRegistrationBean(){

        ServletRegistrationBean<HystrixMetricsStreamServlet> registrationBean
                = new ServletRegistrationBean(new HystrixMetricsStreamServlet());
        registrationBean.addUrlMappings("/actuator/hystrix.stream");
        return registrationBean;
    }
}
