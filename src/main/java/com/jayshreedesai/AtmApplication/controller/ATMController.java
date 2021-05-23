package com.jayshreedesai.AtmApplication.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.jayshreedesai.AtmApplication.entity.Bank;
import com.jayshreedesai.AtmApplication.exception.InsufficientBalanceException;
import com.jayshreedesai.AtmApplication.exception.InvalidAccountNumbereException;
import com.jayshreedesai.AtmApplication.service.ATMService;



@Controller
@RequestMapping("/ATM")
public class ATMController {

	private ATMService ATMService;
	
	public ATMController(ATMService theATMService) {
		ATMService = theATMService;
	}
	
	@RequestMapping("/home")
	public String home(Model theModel){
		
		Bank theBank = new Bank();
		
		theModel.addAttribute("bank", theBank);
		return "ATM/login";
	}	
	
	@GetMapping("/createAccount")
	public String listEmployees(Model theModel) {
		
		Bank theBank = new Bank();
		theModel.addAttribute("bank", theBank);
		return "ATM/createAccountForm";
	}
	
	@PostMapping("/checkBal")
	public String checkBalance(Model theModel,int accountNo) {
	
		Optional<Bank> bankR = ATMService.findByAccountNo(accountNo);
		if(bankR.isPresent()) {
			theModel.addAttribute("bank", bankR.get());
		}
		return "ATM/BalanceDetails";
	}
	
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("bank") Bank bank) {
		
		// save the patient
		ATMService.save(bank);
		
		// use a redirect to prevent duplicate submissions
		return "redirect:/ATM/login";
	}
	
	@PostMapping("/login")
	public String showFormForAdd(Model theModel, @ModelAttribute("bank") Bank theBank) {
	
		int accountNo = theBank.getAccountNo();
		String pin = theBank.getPin();
		Optional<Bank> bankR = ATMService.findByAccountNo(accountNo);
		if(bankR.isPresent() && bankR.get().getPin().equalsIgnoreCase(pin)) {
			theModel.addAttribute("bank", bankR.get());
			return "ATM/User-ATM-Services";
		}
		else {
		
			return "Invalid";
		}
	}
	
	@PostMapping("/deposit")
	public String deposit(double deposit, int accountNo) throws InvalidAccountNumbereException {
		Optional<Bank> bankR = ATMService.findByAccountNo(accountNo);
		if(bankR.isPresent()) {
		double add = deposit + bankR.get().getAmount();
		bankR.get().setAmount(add);
		ATMService.save(bankR.get());
		}
		else {
			throw new InvalidAccountNumbereException("Invalid Account Number");
		}
		
		return "ATM/User-ATM-Services";
	}
	
	@PostMapping("/withdrawal")
	public String withdrawal(double withdrawal, int accountNo) throws InsufficientBalanceException {
		Optional<Bank> bankR = ATMService.findByAccountNo(accountNo);
		if(bankR.isPresent() && bankR.get().getAmount()>withdrawal) {
		double add = bankR.get().getAmount() - withdrawal;
		bankR.get().setAmount(add);
		ATMService.save(bankR.get());
		}
		else {
			throw new InsufficientBalanceException("Balance is Insufficient To withdraw");
		}
		 
		return "ATM/User-ATM-Services";
	}
	
}


















