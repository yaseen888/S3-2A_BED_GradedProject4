package com.greatlearning.employeemanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.employeemanagement.model.Users;
import com.greatlearning.employeemanagement.service.UserService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/security")
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping("/user")
	public Users addUser(@RequestBody Users user) {
		return userService.addUser(user);
	}
	@GetMapping("/user")
	public List<Users> getUser(){
		return userService.getUser();
	}
}
