package com.project.accountmanagement.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.accountmanagement.AccountmanagementApplication;
import com.project.accountmanagement.entity.BankAccount;
import com.project.accountmanagement.entity.Customer;
import com.project.accountmanagement.repository.BankAccountRepository;
import com.project.accountmanagement.repository.CustomerRepository;

@Service
public class ManagerService {

	@Autowired
	private CustomerRepository customerrepository;
	@Autowired
	private BankAccountRepository bankaccountrepository;
	private static Logger LOGGER = LoggerFactory.getLogger(AccountmanagementApplication.class);
	
	
		public Customer createCustomer(Customer customer) {
			String pancard= customer.getPanNumber();
			
			if(customerrepository.getByPanNumber(pancard) ==null) {
				customerrepository.save(customer);
				
			}
			Customer customer1=customerrepository.getByPanNumber(pancard);
			createAccount(customer1.getcId());
			
			return customer1;
		}
		
		public void createAccount(long custid) {
			BankAccount bankaccount= new BankAccount();
			bankaccount.setCustomerId(custid);
			bankaccountrepository.save(bankaccount);
			LOGGER.info("bank account stored");
		
			return;
		}
		
		
	
}
