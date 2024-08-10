package com.demo.microservces.Limit_services.configuration;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;


@Configuration
@ConfigurationProperties(prefix = "limit-services")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LmtConfiguration {

    private int maximum;
    private int minimum;
}
