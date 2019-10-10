package com.hcl.mortgage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.mortgage.dto.LoginRequestDto;
import com.hcl.mortgage.dto.LoginResponseDto;
import com.hcl.mortgage.entity.Customer;
import com.hcl.mortgage.exception.CommonException;
import com.hcl.mortgage.repository.CustomerRepository;
import com.hcl.mortgage.util.ExceptionConstants;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	CustomerRepository customerRepository;

	/*
	 * This method is used to login the customer by providing valid credentials
	 * 
	 * @Param emailId,password
	 * 
	 * @return LoginResponseDto is the return object which includes
	 * customerId,message,statusCode
	 * 
	 */

	@Override
	public LoginResponseDto login(LoginRequestDto loginRequestDto) {
		
		Customer customer = customerRepository.findByEmailIdAndPassword(loginRequestDto.getEmailId(),
				loginRequestDto.getPassword());
		if (customer == null) {
			throw new CommonException(ExceptionConstants.CUSTOMER_NOT_FOUND);
		}

		customer.setEmailId(loginRequestDto.getEmailId());
		customer.setPassword(loginRequestDto.getPassword());

		LoginResponseDto loginResponseDto = new LoginResponseDto();
		loginResponseDto.setCustomerId(customer.getCustomerId());
		loginResponseDto.setStatusCode(201);
		loginResponseDto.setMessage("Log In is successfull");
		return loginResponseDto;
	}

}
