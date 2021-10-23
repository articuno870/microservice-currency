package com.in28minutes.microservices.currencyconversionservice.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.microservices.currencyconversionservice.model.CurrencyConversion;
import com.in28minutes.microservices.currencyconversionservice.proxy.CurrencyExchangeProxy;
import com.in28minutes.microservices.currencyconversionservice.service.CurrencyConversionService;

@RestController
public class CurrencyConversionController {

	@Autowired
	CurrencyConversionService currencyConversionService;
	
	@Autowired
	private CurrencyExchangeProxy proxy;

	@GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion calculateCurrencyConversion(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {

		CurrencyConversion currencyConversion = currencyConversionService.calculateCurrencyConversion(from, to,
				quantity);
		return currencyConversion;

	}

	@GetMapping("/currency-conversion-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion calculateCurrencyConversionFeign(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {

		CurrencyConversion currencyConversion = proxy.retrieveExchangeValue(from, to);

		return new CurrencyConversion(currencyConversion.getId(), from, to, quantity,
				currencyConversion.getConversionMultiple(),
				quantity.multiply(currencyConversion.getConversionMultiple()),
				currencyConversion.getEnvironment() + " " + "feign");

	}

}
