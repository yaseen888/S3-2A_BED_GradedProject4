package com.greatlearning.employeemanagement.service;

import java.util.List;
import java.util.Optional;

import com.greatlearning.employeemanagement.model.Employee;

public interface EmployeeCRUDService {

	List<Employee> getALLEmployees();

	Employee addEmployee(Employee employee);

	Employee getEmployeeById(long id);

	String deleteById(long id);

	Optional<Employee> update(Employee employee);

	List<Employee> searchByFirstName(String firstname);

	List<Employee> getEmployeeSortedByFirstName();





}

