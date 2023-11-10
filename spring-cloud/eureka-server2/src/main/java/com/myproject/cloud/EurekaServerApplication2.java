package com.myproject.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EurekaServerApplication2 {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApplication2.class, args);
    }

}
