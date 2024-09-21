package com.htc.project.model;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="shipping")
public class Shipping {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="shippingid")
	private int shippingid;
	
	@ManyToOne
    @JoinColumn(name="transactionid")
    private Transaction transaction ;
	
	private int productid;
	private  int req;
	private int bill;
	public Shipping(int shippingid, Transaction transaction, int productid, int req, int bill) {
		super();
		this.shippingid = shippingid;
		this.transaction = transaction;
		this.productid = productid;
		this.req = req;
		this.bill = bill;
	}
	
	
	public Shipping(Transaction transaction, int productid, int req, int bill) {
		super();
		this.transaction = transaction;
		this.productid = productid;
		this.req = req;
		this.bill = bill;
	}


	public Shipping() {
		super();
	}
	public int getShippingid() {
		return shippingid;
	}
	public void setShippingid(int shippingid) {
		this.shippingid = shippingid;
	}
	public Transaction getTransaction() {
		return transaction;
	}
	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}
	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}
	public int getReq() {
		return req;
	}
	public void setReq(int req) {
		this.req = req;
	}
	public int getBill() {
		return bill;
	}
	public void setBill(int bill) {
		this.bill = bill;
	}
	
	
	
	
	
}
