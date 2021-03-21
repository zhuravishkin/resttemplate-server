package com.zhuravishkin.resttemplateserver.config;

import com.zhuravishkin.resttemplateserver.handler.WebfluxHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class WebfluxRouter {
    @Bean
    public RouterFunction<ServerResponse> route(WebfluxHandler handler) {
        return RouterFunctions
                .route(RequestPredicates.GET("/webflux")
                        .and(RequestPredicates.accept(MediaType.APPLICATION_JSON)), handler::webfluxHandler);
    }
}
