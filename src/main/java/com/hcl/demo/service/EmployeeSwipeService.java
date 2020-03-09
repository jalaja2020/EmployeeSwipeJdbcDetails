package com.hcl.demo.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.demo.controller.Employee;
import com.hcl.demo.repository.EmployeeSwipeRepository;

@Service
public class EmployeeSwipeService {
	@Autowired 
	EmployeeSwipeRepository employeeSwipeRepository;
	
	 public int insertEmployeeSwipeDetails(Employee employee) {
		 return employeeSwipeRepository.save(employee);
	 }
	 
	 public List<Employee> getEmployeeSwipeDetails(){
	 return employeeSwipeRepository.findAll();	 
	 }
	 
	 public Employee getEmployeeSwipeDetailsById(int id){
		 Optional<Employee> findById = employeeSwipeRepository.findById(id);
		 return  findById.get();
		 }
	 public List<Employee> getEmployeeSwipeDetailsByLocation(String location){
		 return employeeSwipeRepository.findByLocation(location);
		 }
	 
	 public List<Employee> getEmployeeSwipeDetailsByCreatedDate(Date createdDate){
		 return employeeSwipeRepository.findByCreatedDate(createdDate);
		 }

}
