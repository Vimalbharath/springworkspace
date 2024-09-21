package com.htc.springbootdatajpa.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.htc.springbootdatajpa.model.Department;



@Repository("departmentRepository")
public interface DepartmentRepository extends CrudRepository<Department,Integer> {
	
	
	
}
