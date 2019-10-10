package com.hcl.mortgage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.mortgage.dto.LoginRequestDto;
import com.hcl.mortgage.dto.LoginResponseDto;
import com.hcl.mortgage.service.LoginService;

import lombok.extern.slf4j.Slf4j;

@RestController
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
@RequestMapping("/api")
@Slf4j
public class LoginController {

	@Autowired
	LoginService loginService;
	
	/*
	 * This method is used to login the customer by providing valid credentials
	 * 
	 * @RequestBody emailId,password
	 * 
	 * @return LoginResponseDto is the return object which includes customerId,message,statusCode
	 * 
	 */
	
	@PostMapping("/login")
	public ResponseEntity<LoginResponseDto> verify(@RequestBody LoginRequestDto loginRequestDto) {
		
		LoginResponseDto loginResponseDto = loginService.login(loginRequestDto);
		return new ResponseEntity<>(loginResponseDto, HttpStatus.FOUND);
	}
}
