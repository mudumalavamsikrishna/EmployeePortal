package com.socgen.kata.EmployeePortal.controller;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.socgen.kata.EmployeePortal.model.Employee;
import com.socgen.kata.EmployeePortal.repository.EmployeeRepository;

@RestController
@RequestMapping(value="/api/v1")
public class EmployeeController {

	@Autowired
	EmployeeRepository employeeRepository;

	@GetMapping("/employees")
	public List<Employee> getAllEmployees() {
		List<Employee> eList=employeeRepository.findAll();
		
		Collections.sort(eList,Comparator.comparing(Employee::getFirstName));
		return eList;
	}

	@PostMapping("/employees")
	public Employee registerEmployee(@Valid@RequestBody Employee employee) {

		return employeeRepository.save(employee);
	}
}
