package com.htc.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.htc.project.model.Shipping;
import com.htc.project.repo.ShippingRepository;

@Service("shippingService")
public class ShippingService {
	

	@Autowired
	ShippingRepository shippingRepository;



	
	 public List<Shipping> getAllShippings(){
			return (List<Shipping>) shippingRepository.findAll();
		}
}
