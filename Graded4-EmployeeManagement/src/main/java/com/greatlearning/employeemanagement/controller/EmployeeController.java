package com.greatlearning.employeemanagement.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.employeemanagement.model.Employee;
import com.greatlearning.employeemanagement.repository.EmployeeRepository;
import com.greatlearning.employeemanagement.service.EmployeeCRUDService;

import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;


@RestController
@RequestMapping("/employees")

public class EmployeeController {

	@Autowired
	EmployeeCRUDService employeeServiceImpl;

	@Autowired
	EmployeeRepository employeeRepository;

	@ApiOperation(value = "List All Employees",notes = "This API allows you to List All the Records Available in database")
	@GetMapping("/list")
	public List<Employee> getAllEmployees(){

		return employeeServiceImpl.getALLEmployees();

	}

	@ApiOperation(value = "Add Employee", notes = "This API allows you to add a single Employee to Employee table")
	@PostMapping("/addemployee")
	@ResponseStatus(HttpStatus.CREATED)
	public Employee saveEmployee(@RequestBody Employee employee) {
		return employeeServiceImpl.addEmployee(employee);
	}

	@ApiOperation(value = "Get Employee By Id", notes = "This API allows you to get Employee by id")
	@GetMapping("/{id}")
	public Employee getEmployeeById(@PathVariable Long id){

		return employeeServiceImpl.getEmployeeById(id);

	}

	@ApiOperation(value = "Delete Employee By Id",notes = "This API allows you to delete single Employee at a time by ID")
	@DeleteMapping("/delete/{id}")
	public String deleteEmployeeById(@PathVariable("id") Long id) {
		return employeeServiceImpl.deleteById(id);
	}

	@ApiOperation(value = "Update Employee By Id",notes = "This API allows you to update Employee by ID")
	@PutMapping("/update")
	public Optional<Employee> updateEmployee(@RequestBody Employee employee) {
		Optional<Employee> emplo = employeeServiceImpl.update(employee);
		if (emplo.isEmpty()) {
			return Optional.empty();
		} else {
			return emplo;
		}
	}

	@ApiOperation(value = "Search Employee By firstname",notes = "This API allows you to search and list all the same firstname records of Employees")
	@GetMapping("/search/{firstname}")
	public List<Employee> getEmployeeByFirstName(@PathVariable String firstname)
	{
		return employeeServiceImpl.searchByFirstName(firstname);

	}

	@ApiOperation(value = "Sort Employees By firstname",notes = "This API allows you to sort Employees by thier FirstName in Ascending or Decending order")
	@GetMapping("/sort")
	public List<Employee> getEmployeesSortedByFirstName() {
		List<Employee> allEmployee = employeeServiceImpl.getEmployeeSortedByFirstName();
		return allEmployee;
	}


}
