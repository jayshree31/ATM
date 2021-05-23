package com.jayshreedesai.AtmApplication.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="bank")
public class Bank {

	// define fields
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="account_no")
	private int accountNo;

	@Column(name="pin")
	private String pin;
	
	@Column(name="full_name")
	private String fullName;
		
	@Column(name="amount")
	private double amount;
		

	// define constructors
	public Bank() {	
	}

	public Bank(int accountNo, String pin, String fullName, double amount) {
		super();
		this.accountNo = accountNo;
		this.pin = pin;
		this.fullName = fullName;
		this.amount = amount;
	}

	public int getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Bank [accountNo=" + accountNo + ", pin=" + pin + ", fullName=" + fullName + ", amount=" + amount + "]";
	}



			
}











