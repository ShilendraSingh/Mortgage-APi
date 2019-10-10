package com.hcl.mortgage.dto;

import java.time.LocalDateTime;


public class TransactionSummaryDto {
	
	
	
	private Long accountNumber;
	private Long loanAccountNumber;
	private LocalDateTime transactionDateTime;
	private double emi;
	private String description;
	
	
	public Long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public Long getLoanAccountNumber() {
		return loanAccountNumber;
	}
	public void setLoanAccountNumber(Long loanAccountNumber) {
		this.loanAccountNumber = loanAccountNumber;
	}
	public LocalDateTime getTransactionDateTime() {
		return transactionDateTime;
	}
	public void setTransactionDateTime(LocalDateTime transactionDateTime) {
		this.transactionDateTime = transactionDateTime;
	}
	public double getEmi() {
		return emi;
	}
	public void setEmi(double emi) {
		this.emi = emi;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	
	
}
