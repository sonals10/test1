package com.project.accountmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.accountmanagement.entity.Role;

public interface RoleRepository extends JpaRepository<Role,Integer> {

}
