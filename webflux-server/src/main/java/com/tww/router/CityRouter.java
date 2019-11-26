package com.tww.router;

import com.tww.handler.CityHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

/**
 * @program: root
 * @description:
 * @author: weiweiTang
 * @create: 2019-11-25 13:50
 */
@Configuration
public class CityRouter {

    @Autowired
    CityHandler cityHandler;
//    @Bean
    public RouterFunction<ServerResponse> routeCity(CityHandler cityHandler) {
        return route(GET("/hello")
                                .and(RequestPredicates.accept(MediaType.TEXT_PLAIN)),
                        cityHandler::helloCity);
    }

    @Bean
    public RouterFunction<ServerResponse> timerRouter() {
        return route(GET("/times"), cityHandler::sendTimePerSec);  // 增加这一行
    }
}
