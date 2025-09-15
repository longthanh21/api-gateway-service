package com.example.apigateway.config;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Configuration
public class RateLimiterConfig {

    @Bean
    public KeyResolver ipKeyResolver() {
        return (ServerWebExchange exchange) ->
                Mono.justOrEmpty(exchange.getRequest().getRemoteAddress())
                        .map(addr -> addr.getAddress().getHostAddress());
    }
}
