package com.greatlearning.employeemanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.greatlearning.employeemanagement.model.Users;
import com.greatlearning.employeemanagement.repository.UserRepository;
import com.greatlearning.employeemanagement.security.MyUserDetails;

public class UserServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {


		Users user = userRepository.findByUsername(username);

		if(user == null)
			throw new UsernameNotFoundException("Could not find user");


		return new MyUserDetails(user);
	}


}
