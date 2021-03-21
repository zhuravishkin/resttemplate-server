package com.zhuravishkin.resttemplateserver.handler;

import com.zhuravishkin.resttemplateserver.model.User;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class WebfluxHandler {
    public Mono<ServerResponse> webfluxHandler(ServerRequest request) {
        String user = request.queryParam("user")
                .orElse("nobody");
        Integer age = request.queryParam("age")
                .map(Integer::valueOf)
                .orElse(0);
        User tuple = new User(user, age);

        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(tuple));
    }
}
