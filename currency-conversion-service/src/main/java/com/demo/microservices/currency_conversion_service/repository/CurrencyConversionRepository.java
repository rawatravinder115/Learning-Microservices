package com.demo.microservices.currency_conversion_service.repository;

import com.demo.microservices.currency_conversion_service.entity.CurrencyConversionBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyConversionRepository extends JpaRepository<CurrencyConversionBean, Long> {
}
