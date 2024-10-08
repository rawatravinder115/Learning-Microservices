package com.demo.microservices.api_gateway.configuration;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {

    @Bean
    public RouteLocator getewayRouteLocator(RouteLocatorBuilder routeLocatorBuilder){

//        Function<PredicateSpec, Buildable<Route>> routeFunction =
//                                    predicateSpec -> predicateSpec.path("/get")
////                                            .filters(f-> f.addRequestHeader("MyHeader","Ravinder")
////                                                           .addRequestParameter("MyParam","rawat"))
//                                            .uri("http://httpbin.org:80");
        return routeLocatorBuilder.routes()
                                    .route(f ->
                                            f.path("/get")
                                             .uri("http://httpbin.org:80"))
                                    .route(p -> p.path("/currency-conversion/**")
                                                .uri("lb://currency-conversion-service"))
                                    .route(p->p.path("/currency-conversion-feign/**")
                                               .uri("lb://currency-conversion-service"))
                                    .route(p->p.path("/currency-conversion-new/**")
                                                .filters(f->f.rewritePath("/currency-conversion-new/(?<segment>.*)"
                                                        ,"/currency-conversion-feign/${segment}"))
                                               .uri("lb://currency-conversion-service"))
                                    .route(p-> p.path("/currency-exchange/**")
                                                .uri("lb://currency-exchange-service"))
                                    .build();
    }
}
