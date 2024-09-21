package com.htc.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.htc.project.model.Transaction;

import com.htc.project.service.TransactionService;

@RestController
@RequestMapping("/admin")
public class TransactionController {

	@Autowired
	TransactionService transactionService;
	
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
	
	@PutMapping(value="/maketransaction/{transid}")
	public String maketransaction(@PathVariable(name="transid")int transid) {
		String response = "";
	      if( transactionService.makeTransaction(transid) )
	      {
	            response =  "{'status': 'success'}";
	      }
	      else {
	            response=  "{'status': 'fail'}";
	      }
			return response;
	}
	
	
	@GetMapping(value="/transactions")
	public List<Transaction> getAllTransactions(){
		List<Transaction> players=transactionService.getAllTransactions(); 
		System.out.println(players);
		return players;
	}
}
