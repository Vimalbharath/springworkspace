package com.htc.project.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.htc.project.model.Skill;






@Repository("skillRepository")
public interface SkillRepository extends CrudRepository<Skill,Integer> {
	
	
	
}
