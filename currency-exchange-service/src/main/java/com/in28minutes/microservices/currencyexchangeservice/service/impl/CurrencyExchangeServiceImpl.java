package com.in28minutes.microservices.currencyexchangeservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.in28minutes.microservices.currencyexchangeservice.controller.model.CurrencyExchange;
import com.in28minutes.microservices.currencyexchangeservice.dao.CurrencyExchangeRepository;
import com.in28minutes.microservices.currencyexchangeservice.service.CurrencyExchangeService;

@Service
public class CurrencyExchangeServiceImpl implements CurrencyExchangeService {

	@Autowired
	private CurrencyExchangeRepository repository;

	@Override
	public CurrencyExchange findByFromAndTo(String from, String to) {
		CurrencyExchange currencyExchange = repository.findByFromAndTo(from, to);
		return currencyExchange;
	}

}
