package com.project.accountmanagement.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.accountmanagement.entity.AccountTransaction;
import com.project.accountmanagement.entity.BankAccount;
import com.project.accountmanagement.exception.ValueNotFoundException;
import com.project.accountmanagement.repository.AccountTransactionRepository;
import com.project.accountmanagement.repository.BankAccountRepository;

@Service
public class AccountService {
	@Autowired
	private AccountTransactionRepository accounttransactionrepository;
	
	@Autowired
	private BankAccountRepository bankaccountrepository;
	
	public List<AccountTransaction> getStatementsByAccountId(long accountId) throws ValueNotFoundException{
		if(!bankaccountrepository.findById(accountId).isPresent()) {
			throw new ValueNotFoundException("Entered account number is incorrect"+accountId);
		}
		
		List<AccountTransaction> result=accounttransactionrepository.findTop5ByOrderByTransactionDateDesc(accountId);
		
		if(result.isEmpty()) {
			throw new ValueNotFoundException("No transactions were made by this account"+accountId);
		}
		return result;
	}

//	public List<AccountTransaction> getStatementsByDate(Date d) {
//		List<AccountTransaction> result=accounttransactionrepository.getByTransactionDate(d);
//		return result;
//	}

	public List<AccountTransaction> getStatementsByDate(String date) {
		Date d;
		try {
			d = (Date) new SimpleDateFormat("yyyy-MM-dd").parse(date);
			System.out.println("---------------exception try-----------------");
			List<AccountTransaction> result=accounttransactionrepository.getByTransactionDate(d);
			return result;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println("---------------exception-----------------");
		}
		System.out.println("...............................");
		return null;
		
	}

}
