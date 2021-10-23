package com.in28minutes.microservices.currencyconversionservice.dao;

import java.math.BigDecimal;

import com.in28minutes.microservices.currencyconversionservice.model.CurrencyConversion;

public interface CurrencyConversionRepository {

	CurrencyConversion calculateCurrencyConversion(String from, String to, BigDecimal quantity);

	
	
}
