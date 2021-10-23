package com.in28minutes.microservices.currencyconversionservice.dao.impl;

import java.math.BigDecimal;
import java.util.HashMap;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.in28minutes.microservices.currencyconversionservice.dao.CurrencyConversionRepository;
import com.in28minutes.microservices.currencyconversionservice.model.CurrencyConversion;

@Repository
public class CurrencyConversionRepositoryImpl implements CurrencyConversionRepository {
	

	private final RestTemplate restTemplate;

	public CurrencyConversionRepositoryImpl(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate = restTemplateBuilder.build();
	}

	@Override
	public CurrencyConversion calculateCurrencyConversion(String from, String to, BigDecimal quantity) {
		HashMap<String, String> uriVariables = new HashMap<>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);

		ResponseEntity<CurrencyConversion> responseEntity = restTemplate.getForEntity(
				"http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyConversion.class, uriVariables);

		CurrencyConversion currencyConversion = responseEntity.getBody();
		return currencyConversion;
	}

}
