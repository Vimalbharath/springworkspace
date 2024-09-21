package com.htc.springdatajpaER.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.htc.springdatajpaER.model.Department;
import com.htc.springdatajpaER.model.Skill;


@Repository("skillRepository")
public interface SkillRepository extends CrudRepository<Skill,Integer> {
	
	
	
}
