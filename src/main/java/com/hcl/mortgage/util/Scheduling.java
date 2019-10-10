package com.hcl.mortgage.util;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.hcl.mortgage.entity.Account;
import com.hcl.mortgage.entity.LoanDetails;
import com.hcl.mortgage.entity.Transaction;
import com.hcl.mortgage.exception.AccountInsuffcientException;
import com.hcl.mortgage.repository.AccountRepository;
import com.hcl.mortgage.repository.CustomerRepository;
import com.hcl.mortgage.repository.LoanRepository;
import com.hcl.mortgage.repository.TransactionRepository;

@Component
public class Scheduling {

	@Autowired
	private TransactionRepository transactionRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private LoanRepository loanRepository;
	
	@Autowired
	private AccountRepository accountRepository;
	
	
	@Scheduled(cron = "0 0/100000000 * * * *")
	public void emiScheduler()
	{
		List<LoanDetails> loans = loanRepository.findAll();
		
		List<LoanDetails> addedLoans = new ArrayList<>();
		List<Transaction> transactionDetails = new ArrayList<>();
		List<Account> accountData = new ArrayList<>();
		
		loans.stream().forEach(loan -> {
						 
			 LoanDetails loanDetails = new LoanDetails();
			 
			 
			 loan.setTotalAmount(loan.getTotalAmount() - loan.getEmi());
			 BeanUtils.copyProperties(loan, loanDetails);
			 addedLoans.add(loanDetails);
			 
			 
			
			 int customer = loan.getCustomerId();
			 Account accounts = accountRepository.findByCustomerId(customer);
			 
	 if (accounts.getAccountBalance()>loan.getEmi()) {
		 
			 accounts.setAccountBalance(accounts.getAccountBalance() - loan.getEmi());
			 BeanUtils.copyProperties(accounts, accounts);
			 accountData.add(accounts);
			 
			 Transaction transaction = new Transaction();
			 transaction.setAmountDeducted(loan.getEmi());
			 transaction.setCustomerId((long) customer);
			 transaction.setDescription(MortgageUtil.loanDeduction);
			 
			 transaction.setTransactionDate(LocalDateTime.now());
			 transactionDetails.add(transaction);}
	 
	 else
	 {
		 throw new AccountInsuffcientException (" Customer Salary Account  balance is not sufficient ");
	 }
		});
		
		accountRepository.saveAll(accountData);
		loanRepository.saveAll(addedLoans);
		transactionRepository.saveAll(transactionDetails);
		
	}
	
}
