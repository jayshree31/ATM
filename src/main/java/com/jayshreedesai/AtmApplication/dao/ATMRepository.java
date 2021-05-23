 package com.jayshreedesai.AtmApplication.dao;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.jayshreedesai.AtmApplication.entity.Bank;


public interface ATMRepository extends JpaRepository<Bank, Integer> {

	public Optional<Bank> findByAccountNo(int accountNo);
	
	
	
}
