package com.greatlearning.employeemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.greatlearning.employeemanagement.model.Roles;

@Repository
public interface RoleRepository extends JpaRepository<Roles,Integer> {


}
