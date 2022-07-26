package com.project.accountmanagement.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.accountmanagement.entity.BankAccount;
import com.project.accountmanagement.repository.BankAccountRepository;

@Service
public class AccountService {
	
	@Autowired
	private BankAccountRepository bankaccountrepository;

	public Set<HashMap<String, String>> getAccountdetaisByCustomerId(long custid) {
		Set<HashMap<String,String>> finalaccounts= new HashSet<HashMap<String,String>>();
		Optional<List<BankAccount>> bankaccount=bankaccountrepository.findCustomerByCustomerId(custid);
		
		if(bankaccount.isPresent()) {	
			for(BankAccount account: bankaccount.get()){
				HashMap<String,String> accdetails=new HashMap<String,String>();
				accdetails.put("Account number",Long.toString(account.getAccountNumber()));
				accdetails.put("Current balance",Long.toString(account.getCurrentBalance()));
				finalaccounts.add(accdetails);
			}
		}
		
		return finalaccounts;
	}
}
