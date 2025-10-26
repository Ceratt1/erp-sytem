package br.com.erpsystem.gateway.routes;

import java.net.URI;

import org.springframework.cloud.gateway.server.mvc.handler.GatewayRouterFunctions;
import org.springframework.cloud.gateway.server.mvc.handler.HandlerFunctions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.function.RequestPredicates;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerRequest;
import org.springframework.web.servlet.function.ServerResponse;

@Configuration
@SuppressWarnings("deprecation")
public class Routes {
    
    @Bean
    public RouterFunction<ServerResponse> productServiceRoute() {
        return GatewayRouterFunctions.route("product_service")
                .route(RequestPredicates.path("/products/**"),
                       HandlerFunctions.http("http://localhost:8080"))
                .before(request -> {
                    String newPath = request.uri().getPath().replace("/products", "/api/v1/products");
                    return ServerRequest.from(request)
                            .uri(URI.create(newPath))
                            .build();
                })
                .build();
    }

    @Bean
    public RouterFunction<ServerResponse> orderServiceRoute() {
        return GatewayRouterFunctions.route("order_service")
                .route(RequestPredicates.path("/orders/**"),
                       HandlerFunctions.http("http://localhost:8081"))
                .before(request -> {
                    String newPath = request.uri().getPath().replace("/orders", "/api/v1/orders");
                    return ServerRequest.from(request)
                            .uri(URI.create(newPath))
                            .build();
                })
                .build();
    }
}