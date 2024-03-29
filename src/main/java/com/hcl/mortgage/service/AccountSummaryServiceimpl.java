package com.hcl.mortgage.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.mortgage.dto.AccountSummaryResponseDto;
import com.hcl.mortgage.entity.Account;
import com.hcl.mortgage.entity.Customer;
import com.hcl.mortgage.exception.CommonException;
import com.hcl.mortgage.repository.AccountRepository;
import com.hcl.mortgage.repository.CustomerRepository;
import com.hcl.mortgage.util.ExceptionConstants;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AccountSummaryServiceimpl implements AccountSummaryService{

	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	AccountRepository accountRepository;
	
	/*
	 * This method is used to view the customer account summary by providing valid accountNumber
	 * 
	 * @Param customerId
	 * 
	 * @return AccountSummaryResponseDto is the return object which includes accountNumber,accountBalance,message,statusCode
	 * 
	 */
	
	@Override
	public AccountSummaryResponseDto getAccountSummary(Integer customerId) {
		
		
		Account account=accountRepository.findByCustomerId(customerId);
		Optional<Customer> customer=customerRepository.findByCustomerId(customerId);
		
		if (!customer.isPresent()) {
			throw new CommonException(ExceptionConstants.CUSTOMER_NOT_FOUND);
		}	
		

		AccountSummaryResponseDto accountSummaryResponse = new AccountSummaryResponseDto();
//		BeanUtils.copyProperties(customer.get(), accountSummaryResponse);
		accountSummaryResponse.setMessage(ExceptionConstants.PLEASE_FIND_ACCOUNT_DETAILS);
		accountSummaryResponse.setStatusCode(201);
		accountSummaryResponse.setAccountNumber(account.getAccountNumber());
		accountSummaryResponse.setAccountBalance(account.getAccountBalance());
		accountSummaryResponse.setCustomerName(customer.get().getCustomerName());
		return accountSummaryResponse;
	}

	
}
