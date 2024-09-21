package com.htc.springdatajpaER.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.htc.springdatajpaER.model.Department;


@Repository("departmentRepository")
public interface DepartmentRepository extends CrudRepository<Department,Integer> {
	
	
	
}
