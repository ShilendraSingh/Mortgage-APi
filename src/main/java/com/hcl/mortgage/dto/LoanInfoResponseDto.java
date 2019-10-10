package com.hcl.mortgage.dto;

import java.io.Serializable;

public class LoanInfoResponseDto implements Serializable{

	private static final long serialVersionUID = 1L;
	private Double totalAmount;
	private Double emi;
	private Integer statusCode;
	private String message;
	
	public Double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public Double getEmi() {
		return emi;
	}
	public void setEmi(Double emi) {
		this.emi = emi;
	}
	public Integer getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public LoanInfoResponseDto() {
		super();
	}
	
}
