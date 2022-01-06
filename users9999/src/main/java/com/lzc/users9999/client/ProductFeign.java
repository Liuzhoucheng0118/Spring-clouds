package com.lzc.users9999.client;

import com.lzc.users9999.entity.User;
import com.lzc.users9999.fallback.ProductClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @Author liuzhoucheng
 * @Date 2021/12/29 1:16
 * @Version 1.0
 */
@FeignClient(value = "products",fallback = ProductClientFallback.class)
public interface ProductFeign {

    @GetMapping("/product/getGoods")
    String getGoods();

    @GetMapping("/product/goods")
    Map<String,Object> getGoods(@RequestParam("goodsId") Integer goodsId);

    @PostMapping("/product/getUser")
    public Map<String,Object> getUser(@RequestBody User user);

}
