package com.lzc.gateway8989.config;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @Author liuzhoucheng
 * @Date 2022/1/3 17:07
 * @Version 1.0
 */
@Configuration
public class GatewagConfig implements GlobalFilter, Ordered {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder){
        return builder.routes()
                .route("order_route",r->r.path("/order/**").uri("http://localhost:9996/"))
                .build();
    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        if (exchange.getRequest().getQueryParams().get("username")!=null){
            return chain.filter(exchange);  //放行请求
        }
        return exchange.getResponse().setComplete();
    }

    @Override
    public int getOrder() {
        return -1;  //filter 的执行优先级，越小优先级越高 -1最高
    }
}
