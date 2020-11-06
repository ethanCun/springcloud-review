package com.ethan.springcloud.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;

@Configuration
public class ConfigBean {

    //配置Ribbon负载均衡实现, Ribbon基于客户端

    /**
     * IRule: 负载均衡算法：
     *      1. AvailabilityFilteringRule： 过滤掉崩溃的服务，优先选择正常
     *          运行的服务；
     *      2. RoundRobinRule： 轮询
     *      3. RandomRule：随机
     *      4. WeightedResponseTimeRule： 权重
     *      5. RetryRule：重试, 先按照轮询获取服务，如果失败，则会在指定高德时间内重试
     */
    @LoadBalanced
    @Bean
    public RestTemplate restTemplate(){

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters()
                .add(new StringHttpMessageConverter(
                        Charset.forName("utf-8")));

        return restTemplate;
    }

    //将负载均衡算法改为随机，只需要注册一个Bean就行了
//    @Bean
//    public IRule myRule(){
//
//        return new RandomRule();
//    }

}
