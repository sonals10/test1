package com.project.accountmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.accountmanagement.entity.Users;

public interface UsersRepository extends JpaRepository<Users,Long> {

}
