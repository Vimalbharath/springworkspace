package com.htc.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.htc.project.model.Pending;

import com.htc.project.model.Product;
import com.htc.project.model.Shipping;
import com.htc.project.model.Transaction;
import com.htc.project.model.Transaction;
import com.htc.project.repo.PendingRepository;
import com.htc.project.repo.ProductRepository;
import com.htc.project.repo.ShippingRepository;
import com.htc.project.repo.TransactionRepository;

@Service("transactionService")
public class TransactionService {
	

	@Autowired
	TransactionRepository transactionRepository;
	@Autowired
	ShippingRepository shippingRepository;
	@Autowired
	PendingRepository pendingRepository;
	@Autowired
	ProductRepository productRepository;

	public boolean addTransaction(Transaction transaction) {
		
		if(transactionRepository.save(transaction)!=null)
			return true;
		return false;
	}
	
	public boolean makeTransaction(int transactionid) {
		
		
		Optional<Transaction> opttransaction=transactionRepository.findById(transactionid);
		if(opttransaction.isPresent()) {
			Transaction transaction=opttransaction.get();
			
			Product product=transaction.getProductid();
			int req=transaction.getReq();
			int productid=product.getProductid();
			int price=product.getPrice();
			String status="NA";
			
			Optional<Product> optproduct=productRepository.findById(productid);
			if(optproduct.isPresent()) {
				
				Product availproduct=optproduct.get();
				int qoh=availproduct.getQoh();
				
				if(qoh>=req) {
					qoh=qoh-req;
					availproduct.setQoh(qoh);
					productRepository.save(availproduct);
					int bill=price*req;
					Shipping ship=new Shipping(transaction,productid,req,bill);
					bill=price*req;
					
					if(shippingRepository.save(ship)!=null)
						return true;
				}
				else {
					status="NS";
					Pending pend=new Pending(transaction,productid,req,status);
					if(pendingRepository.save(pend)!=null)
						return true;
				}
			}
			
			else {
				status="NA";
				Pending pend=new Pending(transaction,productid,req,status);
				if(pendingRepository.save(pend)!=null)
					return true;
			}
			
			 
			
		}
		
		return false;
	}
	
	
	 public List<Transaction> getAllTransactions(){
			return (List<Transaction>) transactionRepository.findAll();
		}
}
