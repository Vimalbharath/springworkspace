package com.htc.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.htc.project.dto.ProductDTO;
import com.htc.project.model.Pending;
import com.htc.project.model.Product;
import com.htc.project.model.Shipping;
import com.htc.project.model.Transaction;
import com.htc.project.service.PendingService;
import com.htc.project.service.ProductService;
import com.htc.project.service.ShippingService;
import com.htc.project.service.TransactionService;

@RestController
@RequestMapping("/user")
public class PublicController {

	@Autowired
	ProductService productService;
	@Autowired
	TransactionService transactionService;
	@Autowired
	ShippingService shippingService;
	@Autowired
	PendingService pendingService;
	
	@GetMapping(value="/products")
	public List<Product> getAllProducts(){
		List<Product> players=productService.getAllProducts(); 
		System.out.println(players);
		return players;
	}
	@GetMapping(value="/shipping")
	public List<Shipping> getAllShippings(){
		List<Shipping> players=shippingService.getAllShippings();
		System.out.println(players);
		return players;
	}
	@GetMapping(value="/pending")
	public List<Pending> getAllPendings(){
		List<Pending> players=pendingService.getAllPendings();
		System.out.println(players);
		return players;
	}
	
	@PostMapping(value="/transaction", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> addTransaction(@RequestBody Transaction transaction) {
          String response = "";
          if( transactionService.addTransaction(transaction) )
          {
                response =  "{'status': 'success'}";
          }
          else {
                response=  "{'status': 'fail'}";
          }
          
          HttpHeaders headers = new HttpHeaders();
          headers.add("Content-Type", "application/json");
          headers.add("Access-Control-Allow-Origin", "*");
          headers.add("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
          headers.add("Access-Control-Allow-Methods", "GET,PUT,DELETE,POST,OPTIONS");
          
          ResponseEntity<String> respEntity = new ResponseEntity<String>(response, headers, HttpStatus.CREATED);
          return respEntity;
    }
	
	
}
