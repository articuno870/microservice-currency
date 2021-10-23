package com.in28minutes.microservices.currencyconversionservice.service.impl;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.in28minutes.microservices.currencyconversionservice.dao.CurrencyConversionRepository;
import com.in28minutes.microservices.currencyconversionservice.model.CurrencyConversion;
import com.in28minutes.microservices.currencyconversionservice.service.CurrencyConversionService;

@Service
public class CurrencyConversionServiceImpl implements CurrencyConversionService {

	@Autowired
	CurrencyConversionRepository currencyConversionRepository;

	@Override
	public CurrencyConversion calculateCurrencyConversion(String from, String to, BigDecimal quantity) {
		CurrencyConversion currencyConversion = currencyConversionRepository.calculateCurrencyConversion(from, to,
				quantity);

		return new CurrencyConversion(currencyConversion.getId(), from, to, quantity,
				currencyConversion.getConversionMultiple(),
				quantity.multiply(currencyConversion.getConversionMultiple()),
				currencyConversion.getEnvironment() + " " + "rest template");
	}

}
