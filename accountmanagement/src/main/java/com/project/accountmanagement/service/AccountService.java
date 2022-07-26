package com.project.accountmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.accountmanagement.entity.AccountTransaction;
import com.project.accountmanagement.entity.BankAccount;
import com.project.accountmanagement.entity.Customer;
import java.util.Random;  
import com.project.accountmanagement.repository.AccountTransactionRepository;
import com.project.accountmanagement.repository.BankAccountRepository;
import com.project.accountmanagement.repository.CustomerRepository;
import java.util.Date;

@Service
public class AccountService {
	@Autowired
	private CustomerRepository customerrepository;
	@Autowired
	private BankAccountRepository bankaccountrepository;
	@Autowired
	private AccountTransactionRepository accounttransactionrepository;

	
	public AccountTransaction depositamount(long amount, long accountnumber) {
		BankAccount balance= bankaccountrepository.getByAccountNumber(accountnumber);
		balance.setCurrentBalance(balance.getCurrentBalance() + amount);
		bankaccountrepository.setAccountBalance(balance.getCurrentBalance(),accountnumber);
		
		Random random=new Random(); 
		
		AccountTransaction transaction = new AccountTransaction();
		transaction.setAccountNumber(accountnumber);
		transaction.setCurrentBalane(balance.getCurrentBalance());
		transaction.setType("Credit");
		transaction.setSubType("Cash");
		transaction.setTransactionDate(new Date());
		transaction.setTransactionId(random.nextInt(1000000));
		
		accounttransactionrepository.save(transaction);

		return transaction;
	
		//String pancard= customer.getPanNumber();  
//		
//		if(customerrepository.getByPanNumber(pancard) ==null) {
//			customerrepository.save(customer);
//			
//		}
//		Customer customer1=customerrepository.getByPanNumber(pancard);
//		createAccount(customer1.getcId());
//		
//		return customer1;
	}

	public AccountTransaction withdrawamount(long amount, long accountnumber) {
		BankAccount balance= bankaccountrepository.getByAccountNumber(accountnumber);
		balance.setCurrentBalance(balance.getCurrentBalance() - amount);
		bankaccountrepository.setAccountBalance(balance.getCurrentBalance(),accountnumber);
		
		Random random=new Random(); 
		
		AccountTransaction transaction = new AccountTransaction();
		transaction.setAccountNumber(accountnumber);
		transaction.setCurrentBalane(balance.getCurrentBalance());
		transaction.setType("Debit");
		transaction.setSubType("Cash");
		transaction.setTransactionDate(new Date());
		transaction.setTransactionId(random.nextInt(1000000));
		
		accounttransactionrepository.save(transaction);
		
		return transaction;
	
		//String pancard= customer.getPanNumber();  
//		
//		if(customerrepository.getByPanNumber(pancard) ==null) {
//			customerrepository.save(customer);
//			
//		}
//		Customer customer1=customerrepository.getByPanNumber(pancard);
//		createAccount(customer1.getcId());
//		
//		return customer1;
	}
	
	public AccountTransaction transferamount(long amount, long accountnumber1, long accountnumber2) {
		BankAccount balance1= bankaccountrepository.getByAccountNumber(accountnumber1);
		balance1.setCurrentBalance(balance1.getCurrentBalance() - amount);
		BankAccount balance2= bankaccountrepository.getByAccountNumber(accountnumber2);
		balance2.setCurrentBalance(balance2.getCurrentBalance() + amount);
		bankaccountrepository.setAccountBalance(balance1.getCurrentBalance(),accountnumber1);
		bankaccountrepository.setAccountBalance(balance2.getCurrentBalance(),accountnumber2);
		
		Random random=new Random(); 
		
		AccountTransaction transaction = new AccountTransaction();
		transaction.setAccountNumber(accountnumber1);
		transaction.setCurrentBalane(balance1.getCurrentBalance());
		transaction.setType("Debit");
		transaction.setSubType("Transfer");
		transaction.setTransactionDate(new Date());
		transaction.setTransactionId(random.nextInt(1000000));
		
		accounttransactionrepository.save(transaction);
		
		return transaction;
	
		//String pancard= customer.getPanNumber();  
//		
//		if(customerrepository.getByPanNumber(pancard) ==null) {
//			customerrepository.save(customer);
//			
//		}
//		Customer customer1=customerrepository.getByPanNumber(pancard);
//		createAccount(customer1.getcId());
//		
//		return customer1;
	}
	
//	public AccountTransaction withdrawamount(int amount, int accountnumber) {
////		String pancard= customer.getPanNumber();
////		
////		if(customerrepository.getByPanNumber(pancard) ==null) {
////			customerrepository.save(customer);
////			
////		}
////		Customer customer1=customerrepository.getByPanNumber(pancard);
////		createAccount(customer1.getcId());
////		
////		return customer1;
//	}
	
//	public AccountTransaction transferamount(int amount, int accountnumber1, int accountnumber2) {
////		String pancard= customer.getPanNumber();
////		
////		if(customerrepository.getByPanNumber(pancard) ==null) {
////			customerrepository.save(customer);
////			
////		}
////		Customer customer1=customerrepository.getByPanNumber(pancard);
////		createAccount(customer1.getcId());
////		
////		return customer1;
//	}

}
