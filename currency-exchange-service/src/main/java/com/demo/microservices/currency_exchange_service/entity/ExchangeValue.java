package com.demo.microservices.currency_exchange_service.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class ExchangeValue {

    @Id
    private Long id;

    @Column(name = "currecny_from")
    private String from;
    @Column(name = "currecny_to")
    private String to;
    private BigDecimal conversionMultiple;
    private int port;

}
