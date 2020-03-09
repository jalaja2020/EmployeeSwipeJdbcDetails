package com.hcl.demo.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.hcl.demo.controller.Employee;

public interface EmployeeSwipeRepository {
	int save(Employee employee);
	List<Employee> findAll();
	Optional<Employee> findById(int id);
	List<Employee> findByLocation(String location);
	
	List<Employee> findByCreatedDate(Date createdDate);
}
