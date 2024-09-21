package com.example.demosecurity.repository;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demosecurity.entity.*;






@Repository("skillRepository")
public interface SkillRepository extends CrudRepository<Skill,Integer> {
	
	
	
}