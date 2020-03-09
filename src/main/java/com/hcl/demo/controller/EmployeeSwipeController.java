package com.hcl.demo.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.demo.service.EmployeeSwipeService;

@RestController
public class EmployeeSwipeController {

	@Autowired
	EmployeeSwipeService employeeSwipeService;
	@PostMapping("/rest/employee")
	public int insertEmployeeDetails(@RequestBody Employee employee) {
		return employeeSwipeService.insertEmployeeSwipeDetails(employee);
	}
	
	@GetMapping("/rest/employee/all")
	public List<Employee> getEmployeeDetails(){
		return employeeSwipeService.getEmployeeSwipeDetails();
	}
	@GetMapping("/rest/employee/{id}")
	public Employee getEmployeeDetailsById(@PathVariable("id") int id) {
		return employeeSwipeService.getEmployeeSwipeDetailsById(id);
		
	}
	@GetMapping("/rest/employee/location/{location}")
	public List<Employee> getEmployeeDetailsByLocation(@PathVariable("location") String location) {
		return employeeSwipeService.getEmployeeSwipeDetailsByLocation(location);
	}
	
	@GetMapping("/rest/employee/location/{createdDate}")
	public List<Employee> getEmployeeDetailsByDate(@PathVariable("createdDate") String createdDate) {
		 SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
		 Date date = null;
		try {
			date = formatter.parse(createdDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return employeeSwipeService.getEmployeeSwipeDetailsByCreatedDate(date);
	}
	
}
