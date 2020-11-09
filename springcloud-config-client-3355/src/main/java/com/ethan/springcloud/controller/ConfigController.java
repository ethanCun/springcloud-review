package com.ethan.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigController {

    @Value("${spring.application.name}")
    private String applicationName;

    @Value("${eureka.client.service-url.defaultZone}")
    private String eurekaServer;

    @Value("${server.port}")
    private Integer port;


    @RequestMapping(value = "/config")
    public String getConfig(){

        return this.applicationName + " " + this.eurekaServer + " "
                + this.port;
    }

}
