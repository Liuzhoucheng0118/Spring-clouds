package com.lzc.products9998.controller;

import com.lzc.products9998.entity.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author liuzhoucheng
 * @Date 2021/12/26 0:46
 * @Version 1.0
 */
@RestController
@Slf4j
public class ProductController {

    @Value("${server.port}")
    private Integer port;


    @GetMapping("/product/break")
    @HystrixCommand(fallbackMethod = "getExceptionMessage")
    public String testbreak(Integer id){
        if(id<0){
            throw new RuntimeException("id小于0");
        }else{
            return "当前的id="+id;
        }
    }

    public String getExceptionMessage(Integer id){
        return "当前的id不符要求,触发熔断";
    }

    @GetMapping("/product/getGoods")
    public String getGoods(){
        log.info("展示商品列表");
        return "展示商品列表"+port;
    }

    @GetMapping("/product/goods")
    public Map<String,Integer> getGoods(Integer goodsId){
        log.info("获取商品id:[{}]",goodsId);
        HashMap<String,Integer> map = new HashMap<>();
        map.put("goodsId",goodsId);
        map.put("port",port);
        return map;
    }

    @PostMapping("/product/getUser")
    public Map<String,Object> getUser(@RequestBody User user){
        log.info("userId:{},userName:{},age:{}",user.getId(),user.getUserName(),user.getAge());
        User proudctUser = new User(2,"lzc",12);
        HashMap<String,Object> map = new HashMap<>();
        map.put("user",proudctUser);
        return map;
    }
}
