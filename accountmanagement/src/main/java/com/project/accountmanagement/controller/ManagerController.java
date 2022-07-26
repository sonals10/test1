package com.project.accountmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.accountmanagement.entity.Customer;
import com.project.accountmanagement.service.ManagerService;

@RestController
public class ManagerController {
	@Autowired
	private ManagerService managerservice;
	
	@PostMapping("/createcustomer")
	public ResponseEntity<Object> createCustomer(@RequestBody Customer customer){
		String pannumber=customer.getPanNumber();
		
		
		
		return new ResponseEntity<>(customer,HttpStatus.OK);
	}
	
	
}
