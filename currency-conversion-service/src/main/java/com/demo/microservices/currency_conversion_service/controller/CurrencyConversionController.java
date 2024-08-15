package com.demo.microservices.currency_conversion_service.controller;

import com.demo.microservices.currency_conversion_service.client.CurrencyCoversionServiceProxy;
import com.demo.microservices.currency_conversion_service.entity.CurrencyConversionBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Objects;

@RestController
public class CurrencyConversionController {

    @Autowired
    private Environment environment;

    @Autowired
    private CurrencyCoversionServiceProxy proxy;

    @GetMapping("/currecny-converison/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversionBean retriveCurrecyExchange(@PathVariable("from") String from , @PathVariable("to") String to, @PathVariable("quantity")BigDecimal quantity){
        int port = Integer.parseInt(Objects.requireNonNull(environment.getProperty("server.port")));


        HashMap<String,String> uriVariable = new HashMap<>();
        uriVariable.put("from",from);
        uriVariable.put("to",to);
        ResponseEntity<CurrencyConversionBean>  responseEntity = new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/EURO/to/USD",CurrencyConversionBean.class,uriVariable);
        CurrencyConversionBean response = responseEntity.getBody();
        return new CurrencyConversionBean(response.getId(),response.getFrom(),response.getTo(),response.getConversionMultiple(),quantity,quantity.multiply(response.getConversionMultiple()),port);
    }

    @GetMapping("/currecny-converison-feign/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversionBean retriveCurrecyExchangeFeign(@PathVariable("from") String from , @PathVariable("to") String to, @PathVariable("quantity")BigDecimal quantity){
        int port = Integer.parseInt(Objects.requireNonNull(environment.getProperty("server.port")));
        CurrencyConversionBean response = proxy.retriveExchangeValue(from,to);
        return new CurrencyConversionBean(response.getId(),response.getFrom(),response.getTo(),response.getConversionMultiple(),quantity,quantity.multiply(response.getConversionMultiple()),response.getPort());
    }
}
