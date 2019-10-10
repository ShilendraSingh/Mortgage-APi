package com.hcl.mortgage.service;

import com.hcl.mortgage.dto.LoanInfoRequestDto;
import com.hcl.mortgage.dto.LoanInfoResponseDto;

public interface LoanService {

	LoanInfoResponseDto loanInfo(LoanInfoRequestDto loanInforequestDto);
}
