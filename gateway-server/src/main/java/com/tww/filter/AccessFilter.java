package com.tww.filter;

import com.tww.fegin.SsoFeign;
import io.netty.handler.codec.http.cookie.Cookie;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.ApplicationContext;
import org.springframework.core.Ordered;
import org.springframework.http.HttpCookie;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.util.Map;

/**
 * @program: root
 * @description:
 * @author: weiweiTang
 * @create: 2019-07-02 16:57
 */
@Component
public class AccessFilter  implements GlobalFilter, Ordered {

    @Autowired
    private SsoFeign ssoFeign;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        ServerHttpResponse response = exchange.getResponse();

        //访问路径
        String url = request.getURI().toString();

        //从cookie里面取值（Zuul丢失Cookie的解决方案：https://blog.csdn.net/lindan1984/article/details/79308396）
        String accessToken = "123456";
        MultiValueMap<String, HttpCookie> cookies = request.getCookies();
        if(null != cookies){
            cookies.forEach((k,v)->{
                if ("accessToken".equals(k)) {

                }
            });
        }

        //过滤规则：cookie有令牌且存在于Redis，或者访问的是登录页面、登录请求则放行
        if (url.contains("ssoserver/sso/loginPage") || url.contains("ssoserver/sso/login") || (!StringUtils.isEmpty(accessToken) && ssoFeign.hasKey(accessToken))) {
            return chain.filter(exchange);
        } else {
            //重定向到登录页面
            response.setStatusCode(HttpStatus.SEE_OTHER);
            response.getHeaders().set("Location", "http://localhost:4042/ssoserver/sso/loginPage?url=" + url);
            return exchange.getResponse().setComplete();
        }
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
