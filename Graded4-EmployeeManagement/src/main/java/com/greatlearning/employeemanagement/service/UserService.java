package com.greatlearning.employeemanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.employeemanagement.model.Users;
import com.greatlearning.employeemanagement.repository.UserRepository;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	public Users addUser(@RequestBody Users user) {
		return userRepository.saveAndFlush(user);
	}

	public List<Users> getUser() {
		return userRepository.findAll();
	}

}
