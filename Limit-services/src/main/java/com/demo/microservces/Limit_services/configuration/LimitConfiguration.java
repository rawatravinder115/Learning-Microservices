package com.demo.microservces.Limit_services.configuration;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LimitConfiguration {

    private int maximum;
    private int minimum;
}
