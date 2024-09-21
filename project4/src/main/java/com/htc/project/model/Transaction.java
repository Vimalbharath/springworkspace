package com.htc.project.model;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="transaction")
public class Transaction {
	@Id
	@Column(name="transactionid")
	private int transactionid;
	@ManyToOne
    @JoinColumn(name="productid")
    private Product productid ;
	private int req;
	public Transaction(int transactionid, Product productid, int req) {
		super();
		this.transactionid = transactionid;
		this.productid = productid;
		this.req = req;
	}
	public Transaction() {
		super();
	}
	public int getTransactionid() {
		return transactionid;
	}
	public void setTransactionid(int transactionid) {
		this.transactionid = transactionid;
	}
	public Product getProductid() {
		return productid;
	}
	public void setProductid(Product productid) {
		this.productid = productid;
	}
	public int getReq() {
		return req;
	}
	public void setReq(int req) {
		this.req = req;
	}
	
}
