package com.zincwish.reactive.handler;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sun.management.OperatingSystemMXBean;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.lang.management.ManagementFactory;
import java.time.Duration;

@Component
public class HealthHandler {

    private final OperatingSystemMXBean bean = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();

    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public Mono<ServerResponse> healthData(ServerRequest request) {
        return ServerResponse.ok().contentType(MediaType.APPLICATION_STREAM_JSON)
                .body(
                        Flux.interval(Duration.ofSeconds(1))
                                .map(l -> gson.toJson(new HealthInfo(bean.getCpuLoad())) + "\n\r"), String.class

                );
    }

    class HealthInfo {

        private double cpuLoad;

        HealthInfo(double cpuLoad) {
            this.cpuLoad = cpuLoad;
        }

    }


}
