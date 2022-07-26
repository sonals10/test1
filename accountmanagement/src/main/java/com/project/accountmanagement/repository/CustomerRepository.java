package com.project.accountmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.accountmanagement.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long>{
	
//	@Query("Select pan_number from customer where ")
//	public String findByPanNumber(@Param("panNumber") String panNumber) {
//		
//	}
	
	Customer getByPanNumber(String panNumber);
}
