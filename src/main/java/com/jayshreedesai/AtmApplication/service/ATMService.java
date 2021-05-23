package com.jayshreedesai.AtmApplication.service;

import java.util.List;
import java.util.Optional;

import com.jayshreedesai.AtmApplication.entity.Bank;



public interface ATMService {

	public Optional<Bank> findByAccountNo(int accountNo);
	
	public List<Bank> findAll();
	
	public Bank findByfullName(String name);
	
	public void save(Bank theBank);
	
	public void deleteById(int theId);
	
	
	
}
