package com.ethan.rule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

//自定义Ribbon的负载均衡算法
//自定义的Rule不能和启动类在同一个包下
@Configuration
public class MyRule{

    //默认的轮询算法
    //@Bean
    public IRule roundRobinRule(){

        return new RoundRobinRule();
    }

    //@Bean
    public IRule retryRule(){

        return new RetryRule();
    }

    //自定义的负载均衡算法
    @Bean
    public IRule myRandomRule(){

        return new MyRandomRule();
    }
}
