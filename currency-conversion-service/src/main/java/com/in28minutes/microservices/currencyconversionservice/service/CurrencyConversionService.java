package com.in28minutes.microservices.currencyconversionservice.service;

import java.math.BigDecimal;

import com.in28minutes.microservices.currencyconversionservice.model.CurrencyConversion;

public interface CurrencyConversionService {

	CurrencyConversion calculateCurrencyConversion(String from, String to, BigDecimal quantity);

}
