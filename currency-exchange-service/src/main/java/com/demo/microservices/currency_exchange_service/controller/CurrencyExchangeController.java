package com.demo.microservices.currency_exchange_service.controller;

import com.demo.microservices.currency_exchange_service.entity.ExchangeValue;
import com.demo.microservices.currency_exchange_service.repository.ExchangeValueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
public class CurrencyExchangeController {

    @Autowired
    private Environment environment;

    @Autowired
    private ExchangeValueRepository exchangeValueRepository;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public ExchangeValue retriveExchangeValue(@PathVariable("from") String from , @PathVariable("to") String to){
        int port = Integer.parseInt(Objects.requireNonNull(environment.getProperty("server.port")));
        ExchangeValue exc = exchangeValueRepository.findByFromAndTo(from, to);
        System.out.println("ExchangeValue :::: " + exc.toString());
        exc.setPort(port);
        return exc;

    }
}
