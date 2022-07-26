package com.project.accountmanagement.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.accountmanagement.entity.BankAccount;

public interface BankAccountRepository extends JpaRepository<BankAccount,Long>{

	

	Optional<List<BankAccount>> findCustomerByCustomerId(long custid);

}
