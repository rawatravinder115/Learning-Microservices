package com.demo.microservces.Limit_services.controller;

import com.demo.microservces.Limit_services.bean.LimitConfiguration;
import com.demo.microservces.Limit_services.configuration.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigController {


    private Configuration configuration;

    public ConfigController(Configuration configuration){
        this.configuration = configuration;
    }

    @GetMapping("/limits")
    public LimitConfiguration retrivalLimitConfiguration(){
        System.out.println("lmtConfiguration.getMaximum() :::: " + configuration.getMaximum() + " lmtConfiguration.getMinimum() "+ configuration.getMinimum());
        return new LimitConfiguration(configuration.getMaximum(), configuration.getMinimum());
    }
}
