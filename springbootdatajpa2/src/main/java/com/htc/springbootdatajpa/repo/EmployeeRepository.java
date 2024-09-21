package com.htc.springbootdatajpa.repo;

import java.util.Collection;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.htc.springbootdatajpa.model.Employee;


@Repository("employeeRepository")
public interface EmployeeRepository extends CrudRepository<Employee,Integer> {
	
	public List<Employee> findByageBetween(int upper,int lower);
	
	public List<Employee> findByLocationIn(Collection<String> locations);
	
}