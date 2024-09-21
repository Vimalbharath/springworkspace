package com.htc.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.htc.project.model.Pending;
import com.htc.project.repo.PendingRepository;

@Service("pendingService")
public class PendingService {
	

	@Autowired
	PendingRepository pendingRepository;



	
	 public List<Pending> getAllPendings(){
			return (List<Pending>) pendingRepository.findAll();
		}
}
