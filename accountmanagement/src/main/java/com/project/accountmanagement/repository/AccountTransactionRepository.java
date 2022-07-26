package com.project.accountmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.accountmanagement.entity.AccountTransaction;

public interface AccountTransactionRepository extends JpaRepository<AccountTransaction,Integer> {
	
}
