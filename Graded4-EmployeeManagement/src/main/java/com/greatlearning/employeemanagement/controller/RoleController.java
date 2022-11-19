package com.greatlearning.employeemanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.employeemanagement.model.Roles;
import com.greatlearning.employeemanagement.service.RoleService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;


@RestController
@RequestMapping("/security")
public class RoleController {

	@Autowired
	RoleService roleService;

	@PostMapping("/role")
	public Roles addRole(@RequestBody  Roles role) {
		return roleService.addRole(role);
	}
	@GetMapping("/role")
	public List<Roles> getRole(){
		return roleService.getRole();
	}
}

