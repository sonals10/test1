package com.project.accountmanagement.controller;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
//import java.util.Date;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.accountmanagement.entity.AccountTransaction;
import com.project.accountmanagement.entity.BankAccount;
import com.project.accountmanagement.exception.ValueNotFoundException;
import com.project.accountmanagement.service.AccountService;

@RestController
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
//	@GetMapping("/accounts/{id}")
//	public List<BankAccount> getAccountsByCustomerId(@PathVariable long id){
//		
//		return 
//	}
	
	@GetMapping("/statement/{accountnumber}")
	public List<AccountTransaction> getStatementsByAccountId(@PathVariable long accountnumber) throws ValueNotFoundException{
//		Sysout
//		accountId=1;
		System.out.println("-----------------------------------------------------------------------deeeeeeeeeeeeeeeeeeee------------------");
		return accountService.getStatementsByAccountId(accountnumber);
	}
	
	@GetMapping("/statements/{date}")
	public List<AccountTransaction> getStatementsByDate(@PathVariable String date){
		
		return accountService.getStatementsByDate(date);
	}
//	
//	@PostMapping("/deposit")
//	public AccountTransaction newTransactionByDeposit(@RequestParam(value="amount") int amount,
//			@RequestParam(value="accountnumber") int accountnumber){
//		
//		return 
//	}
//	
//	@PostMapping("/withdrawal")
//	public AccountTransaction newTransactionByWithdrawal(@RequestParam(value="amount") int amount,
//			@RequestParam(value="accountnumber") int accountnumber){
//		
//		return 
//	}
//	
//	@PostMapping("/transfer")
//	public AccountTransaction newTransactionByTransfer(@RequestParam(value="amount") int amount,
//			@RequestParam(value="accountnumber1") int accountnumber1, @RequestParam(value="accountnumber2") int accountnumber2){
//		
//		return 
//	}
}