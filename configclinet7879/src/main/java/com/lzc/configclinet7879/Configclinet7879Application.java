package com.lzc.configclinet7879;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Configclinet7879Application {

    public static void main(String[] args) {
        SpringApplication.run(Configclinet7879Application.class, args);
    }

}
