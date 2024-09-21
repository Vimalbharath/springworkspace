package com.htc.project.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.htc.project.converter.SkillConverter;
import com.htc.project.dto.SkillDTO;
import com.htc.project.model.Player;
import com.htc.project.model.Skill;
import com.htc.project.model.Team;
import com.htc.project.repo.PlayerRepository;
import com.htc.project.repo.SkillRepository;


@Service("skillService")
public class SkillService {
	@Autowired
	SkillRepository skillRepository;
	@Autowired
	PlayerRepository playerRepository;
	@Autowired
	SkillConverter skillConvertor;
	

	public boolean addSkill(SkillDTO skill) {
		Skill skillObj=skillConvertor.dtoToEntity(skill);
		if(skillRepository.save(skillObj)!=null)
			return true;
		return false;
	}
	
	public boolean playerhasthisskill(int playerid,int skillid) {
		Optional<Player> optplayer=playerRepository.findById(playerid);
		Optional<Skill> optskill=skillRepository.findById(skillid);
		
		if(optplayer.isPresent()&&optskill.isPresent()) {
			Player player=optplayer.get();
			Skill skil=optskill.get();
			
			Set<Skill> skills=player.getSkill();
			
			if(skills == null)
				skills=new HashSet<Skill>();
			skills.add(skil);
			player.setSkill(skills);
			playerRepository.save(player);
			return true;
		}
		return false;
	}
	public List<Skill> getAllSkills(){
		return (List<Skill>) skillRepository.findAll();
	}
}
