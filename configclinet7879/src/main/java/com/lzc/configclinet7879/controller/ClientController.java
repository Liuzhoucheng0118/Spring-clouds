package com.lzc.configclinet7879.controller;

import jdk.nashorn.internal.ir.annotations.Reference;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author liuzhoucheng
 * @Date 2022/1/5 21:14
 * @Version 1.0
 */
@RestController
@RefreshScope
public class ClientController {

    @Value("${server.port}")
    private int port;

    @Value("${username}")
    private String username;

    @GetMapping("/client/init")
    public String getPort(){
        return "服务的端口为："+port+"----名字："+username;
    }
}
