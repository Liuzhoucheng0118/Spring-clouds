package com.lzc.configserver7878;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
@EnableDiscoveryClient
public class Configserver7878Application {

    public static void main(String[] args) {
        SpringApplication.run(Configserver7878Application.class, args);
    }

}
