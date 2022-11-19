package com.greatlearning.employeemanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.employeemanagement.model.Roles;
import com.greatlearning.employeemanagement.repository.RoleRepository;

@Service
public class RoleService {

	@Autowired
	RoleRepository roleRepository;

	public Roles addRole(Roles role) {
		return roleRepository.saveAndFlush(role);
	}
	public List<Roles> getRole() {
		return roleRepository.findAll();
	}

}
