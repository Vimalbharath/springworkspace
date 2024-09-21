package com.htc.springbootdatajpa.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.htc.springbootdatajpa.model.Skill;




@Repository("skillRepository")
public interface SkillRepository extends CrudRepository<Skill,Integer> {
	
	
	
}
