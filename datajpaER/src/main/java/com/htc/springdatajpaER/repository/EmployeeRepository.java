package com.htc.springdatajpaER.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.htc.springdatajpaER.model.Employee;


@Repository("employeeRepository")
public interface EmployeeRepository extends CrudRepository<Employee,Integer> {
	
	
	
}
