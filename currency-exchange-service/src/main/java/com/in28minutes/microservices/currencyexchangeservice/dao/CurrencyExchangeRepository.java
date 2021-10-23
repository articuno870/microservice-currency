package com.in28minutes.microservices.currencyexchangeservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.in28minutes.microservices.currencyexchangeservice.controller.model.CurrencyExchange;

@Repository
public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange, Long> {
	
	@Query("select c from CurrencyExchange c where c.from = :from and c.to = :to")
	public CurrencyExchange findByFromAndTo(String from, String to);
}
