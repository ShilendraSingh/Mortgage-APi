package com.hcl.mortgage.util;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

@Component
public class MortgageUtil {

	
	public static final String loanDeduction = "Loan deducted on "+LocalDateTime.now();
}
