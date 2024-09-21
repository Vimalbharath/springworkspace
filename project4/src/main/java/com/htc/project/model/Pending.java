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
@Table(name="pending")
public class Pending {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="pendingid")
	private int pendingid;
	
	@ManyToOne
    @JoinColumn(name="transactionid")
    private Transaction transaction ;
	
	private int productid;
	private int req;
	private String status;
	public Pending(int pendingid, Transaction transaction, int productid, int req, String status) {
		super();
		this.pendingid = pendingid;
		this.transaction = transaction;
		this.productid = productid;
		this.req = req;
		this.status = status;
	}
	
	
	public Pending(Transaction transaction, int productid, int req, String status) {
		super();
		this.transaction = transaction;
		this.productid = productid;
		this.req = req;
		this.status = status;
	}


	public Pending() {
		super();
	}
	public int getPendingid() {
		return pendingid;
	}
	public void setPendingid(int pendingid) {
		this.pendingid = pendingid;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	
	
}
