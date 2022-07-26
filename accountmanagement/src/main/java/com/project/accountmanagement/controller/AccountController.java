package com.project.accountmanagement.controller;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.accountmanagement.entity.AccountTransaction;
import com.project.accountmanagement.entity.BankAccount;
import com.project.accountmanagement.service.AccountService;



@RestController
public class AccountController {
	
	@Autowired
	private AccountService accountservice;
	
	@GetMapping("/accounts/{id}")
	public Set<HashMap<String,String>> getAccountsByCustomerId(@PathVariable long id){
	
		
    return accountservice.getAccountdetaisByCustomerId(id);
			
	}
	
//	@GetMapping("/statement/{id}")
//	public List<AccountTransaction> getStatementsByAccountId(@PathVariable long accountId){
//		
//	//	return 
//	}
//	@GetMapping("/statement/{date}")
//	public List<AccountTransaction> getStatementsByDate(@PathVariable Date date){
//		
//	//	return 
//	}
//	
//	@PostMapping("/deposit")
//	public AccountTransaction newTransactionByDeposit(@RequestParam(value="amount") int amount,
//			@RequestParam(value="accountnumber") int accountnumber){
//		
//	//	return 
//	}
//	
//	@PostMapping("/withdrawal")
//	public AccountTransaction newTransactionByWithdrawal(@RequestParam(value="amount") int amount,
//			@RequestParam(value="accountnumber") int accountnumber){
//		
//	//	return 
//	}
//	
//	@PostMapping("/transfer")
//	public AccountTransaction newTransactionByTransfer(@RequestParam(value="amount") int amount,
//			@RequestParam(value="accountnumber1") int accountnumber1, @RequestParam(value="accountnumber2") int accountnumber2){
//		
//	//	return 
//	}
}