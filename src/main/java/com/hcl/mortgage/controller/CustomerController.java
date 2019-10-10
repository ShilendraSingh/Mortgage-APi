package com.hcl.mortgage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.mortgage.dto.CustomerRequestDto;
import com.hcl.mortgage.dto.CustomerResponseDto;
import com.hcl.mortgage.service.CustomerService;

@RestController
@RequestMapping("/api")
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
public class CustomerController {
		
	@Autowired
	CustomerService customerService;
	@PostMapping("/register")
	public ResponseEntity<CustomerResponseDto> customerRegistration(@RequestBody CustomerRequestDto customerRequestDto){
		CustomerResponseDto customerResponseDto=new CustomerResponseDto();
		String message=customerService.registerCustomer(customerRequestDto);
		customerResponseDto.setMessage(message);
		customerResponseDto.setStatusCode(200);
		
		return null;
	}
}
