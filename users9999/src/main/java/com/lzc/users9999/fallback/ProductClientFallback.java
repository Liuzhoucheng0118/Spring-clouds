package com.lzc.users9999.fallback;

import com.lzc.users9999.client.ProductFeign;
import com.lzc.users9999.entity.User;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author liuzhoucheng
 * @Date 2022/1/3 15:29
 * @Version 1.0
 */
@Component
public class ProductClientFallback implements ProductFeign {

    private HashMap<String,Object> result = new HashMap<>();
    @Override
    public String getGoods() {
        return "服务降级";
    }

    @Override
    public Map<String, Object> getGoods(Integer goodsId) {
        result.put("status",false);
        result.put("message","getGoods服务已经降级");
        return result;
    }

    @Override
    public Map<String, Object> getUser(User user) {
        result.put("status",false);
        result.put("message","getUser服务已经降级");
        return result;
    }
}
