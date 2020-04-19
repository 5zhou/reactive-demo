package com.zincwish.reactive.router;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sun.management.OperatingSystemMXBean;
import com.zincwish.reactive.handler.GreetingHandler;
import com.zincwish.reactive.handler.HealthHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import java.lang.management.ManagementFactory;

@Configuration
public class GreetingRouter {

    private OperatingSystemMXBean bean = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();


    @Bean
    public RouterFunction<ServerResponse> route(GreetingHandler greetingHandler) {
        return RouterFunctions
                .route(RequestPredicates.GET("/hellp")
                        .and(RequestPredicates.accept(MediaType.TEXT_PLAIN)), greetingHandler::hello);
    }


    @Bean
    public RouterFunction<ServerResponse> healthRouter(HealthHandler healthHandler){
        return RouterFunctions
                .route(RequestPredicates.GET("/health")
                .and(RequestPredicates.accept(MediaType.APPLICATION_STREAM_JSON)), healthHandler::healthData);
    }

}
