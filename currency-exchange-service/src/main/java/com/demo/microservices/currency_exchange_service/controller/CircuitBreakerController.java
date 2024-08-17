package com.demo.microservices.currency_exchange_service.controller;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CircuitBreakerController {

    private Logger LOGGER = LoggerFactory.getLogger(CircuitBreakerController.class);

    @GetMapping("/sample-api")
//    @Retry(name = "default",fallbackMethod = "HandleFallBack")  // byDefault Default has 3 retry calls.

//    @CircuitBreaker(name = "default",fallbackMethod = "HandleFallBack")
//    @RateLimiter(name = "default")
    @Bulkhead(name="sample-api")
    public String sampleMethod(){
        LOGGER.info("Request Received  :::::: ");

        ResponseEntity<String> forEntity =new  RestTemplate().getForEntity("http://localhost:8080/dummy-api",String.class);
        return forEntity.getBody();
    }

    public String HandleFallBack(Exception ex){
        return "Fallback Response";
    }
}
