package com.project.accountmanagement;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.project.accountmanagement.entity.Customer;
import com.project.accountmanagement.entity.Role;
import com.project.accountmanagement.entity.Users;
import com.project.accountmanagement.repository.CustomerRepository;
import com.project.accountmanagement.repository.RoleRepository;
import com.project.accountmanagement.repository.UsersRepository;


@SpringBootApplication
public class AccountmanagementApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(AccountmanagementApplication.class, args);
	}
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private UsersRepository usersRepository;
	
//	@Autowired
//	private CustomerRepository customerRepository;
	
	private static Logger LOGGER = LoggerFactory.getLogger(AccountmanagementApplication.class);
	
	@Override
	public void run(String... args) throws Exception {
		LOGGER.info("..................................assigning default roles and manager values..................................");
		Role r1= new Role(1, "Manager");
		Role r2= new Role(2, "Customer");
		Users u1=new Users(12345,"12345",1);
		
//		Date d=new SimpleDateFormat("yyyy-MM-dd").parse("2022-07-26");
//		Customer c1=new Customer(1,"ranveer",d,"FV7EE98SFV","789012344556","pune, blah blah road, area","ranveer@gmail.com");
		roleRepository.save(r1);
		roleRepository.save(r2);
		usersRepository.save(u1);
//		customerRepository.save(c1);
	}

}
