package com.vobi.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/balances")
@CrossOrigin("*")
public class BalanceController {
	
	@Autowired
	JdbcTemplate jdTemplate;
	
	@GetMapping("/{id}")
	public double findBalance(@PathVariable("id") String id) {
		String query = String.format("SELECT balance FROM account WHERE acco_id='%s'",id);
		Double balance = jdTemplate.queryForObject(query, double.class);
		return balance;
	}
	
	@GetMapping("/sayHello/{nombre}")
	public String sayHello(@PathVariable("nombre") String name) {
		return "hello " + name;
	}
}

class BalanceDTO{
	
	private double balance;
	
	public BalanceDTO(Double balance){
		this.balance = balance;
	}
	
	public Double getBalance() {
		return this.balance;
	}
}
