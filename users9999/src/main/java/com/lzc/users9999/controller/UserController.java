package com.lzc.users9999.controller;

import com.lzc.users9999.client.ProductFeign;
import com.lzc.users9999.entity.User;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import com.sun.javafx.collections.MappingChange;
import lombok.extern.slf4j.Slf4j;
import org.omg.CORBA.OBJ_ADAPTER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * @Author liuzhoucheng
 * @Date 2021/12/26 19:18
 * @Version 1.0
 */
@RestController
@Slf4j
public class UserController {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ProductFeign productFeign;



    @GetMapping("/user/getGoods")
    public String getGoods() {
//        String msg = restTemplate.getForObject("http://products/product/getGoods", String.class);
        String msg = productFeign.getGoods();
        return msg;
    }

    @GetMapping("/user/Goods")
    public Map<String,Object> getGoods(@RequestParam("goodsId") Integer goodsId){
        Map<String, Object> map = productFeign.getGoods(goodsId);
        log.info("goodsId:{},port:{}",map.get("goodsId"),map.get("port"));
        return map;
    }

    @GetMapping("/user/user")
    public Map<String, Object> getUser(User user){
        log.info("收到的消息为:{}",user);
        Map<String, Object> map = productFeign.getUser(user);
        return map;
    }
}
