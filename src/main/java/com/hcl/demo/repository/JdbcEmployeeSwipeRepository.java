package com.hcl.demo.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.hcl.demo.controller.Employee;
@Repository
public class JdbcEmployeeSwipeRepository  implements EmployeeSwipeRepository{

	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	@Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Override
	public int save(Employee employee) {
		 return jdbcTemplate.update(
	                "insert into employee(empid, empname,locationname,swipein,swipeout,createDate) values(?,?,?,?,?,?)",
	                employee.getEmpId(), employee.getEmpName(),employee.getLocationName(),employee.getSwipeIn(),employee.getSwipeOut(),employee.getCreateDate());
	}

	@Override
	public List<Employee> findAll() {
	        return jdbcTemplate.query(
	                "select * from employee",
	                (rs, rowNum) ->
	                        new Employee(
	                        		rs.getInt("empId"),
	                                rs.getString("empName"),
	                                rs.getString("swipeIn"),
	                                rs.getString("swipeOut"),
	                                rs.getDate("createDate"),
	                                rs.getString("locationName")
	                        )
	        );
	}

	@Override
	public Optional<Employee> findById(int id) {
		 return jdbcTemplate.queryForObject(
	                "select * from employee where empId = ?",
	                new Object[]{id},
	                (rs, rowNum) ->
	                        Optional.of(new Employee(
	                        		rs.getInt("empId"),
	                                rs.getString("empName"),
	                                rs.getString("swipeIn"),
	                                rs.getString("swipeOut"),
	                                rs.getDate("createDate"),
	                                rs.getString("locationName")
	                        ))
	        );
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> findByLocation(String location) {
		 return namedParameterJdbcTemplate.query("select * from employee where locationName  like :location",
				 new MapSqlParameterSource().addValue("location", location),
				 (rs, rowNum) -> new Employee(
                 		rs.getInt("empId"),
                        rs.getString("empName"),
                        rs.getString("swipeIn"),
                        rs.getString("swipeOut"),
                        rs.getDate("createDate"),
                        rs.getString("locationName")
                ));
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> findByCreatedDate(Date createdDate) {
		 return namedParameterJdbcTemplate.query("select * from employee where createDate= :createdDate",
				 new MapSqlParameterSource().addValue("createDate", createdDate),
				 (rs, rowNum) -> new Employee(
                 		rs.getInt("empId"),
                        rs.getString("empName"),
                        rs.getString("swipeIn"),
                        rs.getString("swipeOut"),
                        rs.getDate("createDate"),
                        rs.getString("locationName")
                ));
	}
}
