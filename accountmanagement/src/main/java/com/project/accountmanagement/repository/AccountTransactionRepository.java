package com.project.accountmanagement.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.accountmanagement.entity.AccountTransaction;

public interface AccountTransactionRepository extends JpaRepository<AccountTransaction,Integer> {
	List<AccountTransaction> getByAccountNumber(long accountNumber);
//	List<AccountTransaction> findTop5ByAccountTransactionsByTransactionDateDesc();

	List<AccountTransaction> getByTransactionDate(Date transactionDate);
	
	@Query(value="SELECT t FROM AccountTransaction t")
	List<AccountTransaction> findTop5ByOrderByTransactionDateDesc(long accountNumber);
}
