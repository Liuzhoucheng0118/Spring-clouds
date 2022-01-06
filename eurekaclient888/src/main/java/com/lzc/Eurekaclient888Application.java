package com.lzc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class Eurekaclient888Application {

    public static void main(String[] args) {
        SpringApplication.run(Eurekaclient888Application.class, args);
    }

}
