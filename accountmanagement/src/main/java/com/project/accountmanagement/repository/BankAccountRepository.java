package com.project.accountmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.accountmanagement.entity.BankAccount;

public interface BankAccountRepository extends JpaRepository<BankAccount,Long>{

}
