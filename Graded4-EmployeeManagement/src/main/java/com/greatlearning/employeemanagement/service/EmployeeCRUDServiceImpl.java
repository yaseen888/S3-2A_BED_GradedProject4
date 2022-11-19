package com.greatlearning.employeemanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.greatlearning.employeemanagement.model.Employee;
import com.greatlearning.employeemanagement.repository.EmployeeRepository;

@Service
public class EmployeeCRUDServiceImpl implements EmployeeCRUDService {

	@Autowired
	EmployeeRepository employeeRepository;

	//It provides list of all employees
	@Override
	public List<Employee> getALLEmployees() {

		return	employeeRepository.findAll();
	}

	//This method add employees to database
	@Override
	public Employee addEmployee(Employee employee) {

		return employeeRepository.saveAndFlush(employee);
	}

	//fetch or get an employee by Id
	@Override
	public Employee  getEmployeeById(long id) {

		return employeeRepository.findById(id)
				.orElseThrow(()-> new IllegalArgumentException("Employee not found for id :: " + id));
	}

	//delete employee by Id
	@Override
	public String deleteById(long id) {
		if (employeeRepository.existsById(id)) {

			employeeRepository.deleteById(id);

			return "Deleted Employee Id:"+ id;
		} else {
			return "The Employee does not exists";
		}

	}


	//list all employees sorted  in Ascending order
	@Override
	public List<Employee> getEmployeeSortedByFirstName() {
		return employeeRepository.findAll(Sort.by(Direction.ASC,"firstname" ));
	}


	//it provides updation
	@Override
	public Optional<Employee> update(Employee employee) {
		if (employeeRepository.existsById(employee.getId())) {
			return Optional.of(employeeRepository.save(employee));
		} else {
			return Optional.empty();
		}
	}

	//fetch employee by firstname
	@Override
	public List<Employee> searchByFirstName(String firstname) {
		Employee employeeWithSameNames = new Employee();
		employeeWithSameNames.setFirstname(firstname);
		// Below exampleMatcher will make sure that only commaSeperatedBooknamesis
		// considered and id and name are ignored
		ExampleMatcher exampleMatcher = ExampleMatcher.matching()
				.withMatcher("firstname", ExampleMatcher.GenericPropertyMatchers.exact())
				.withIgnorePaths("id", "lastname","email");
		Example<Employee> example = Example.of(employeeWithSameNames, exampleMatcher);
		return employeeRepository.findAll(example);
	}
}
