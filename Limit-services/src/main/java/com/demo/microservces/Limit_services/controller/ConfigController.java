package com.demo.microservces.Limit_services.controller;

import com.demo.microservces.Limit_services.configuration.LimitConfiguration;
import com.demo.microservces.Limit_services.configuration.LmtConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigController {

    @Autowired
    private LmtConfiguration lmtConfiguration;

    @GetMapping("/limits")
    public LimitConfiguration retrivalLimitConfiguration(){
        return new LimitConfiguration(lmtConfiguration.getMaximum(), lmtConfiguration.getMinimum());
    }
}
