package com.hcl.mortgage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.mortgage.dto.AccountSummaryResponseDto;
import com.hcl.mortgage.service.AccountSummaryService;

import lombok.extern.slf4j.Slf4j;

@RestController
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
@RequestMapping("/api")
@Slf4j
public class AccountSummaryController {

	@Autowired
	AccountSummaryService accountSummaryService;
	
	/*
	 * This method is used to get the account details for particular customer.
	 * 
	 * @PathVariable customerId
	 * 
	 * @return AccountSummaryResponseDto is the return object which includes
	 * accountNumber,accountBalance,customerName,message,statusCode
	 * 
	 */
	
	@GetMapping("/customers/{customerId}")
	public ResponseEntity<AccountSummaryResponseDto> getAccountSummary(@PathVariable Integer customerId) {
	
		return new ResponseEntity<>(accountSummaryService.getAccountSummary(customerId), HttpStatus.OK);
	}
}
