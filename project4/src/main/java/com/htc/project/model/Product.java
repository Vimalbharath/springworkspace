package com.htc.project.model;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="product")
public class Product {
	@Id
	@Column(name="productid")
	private int productid;
	private String name;
	private int qoh;
	private int price;
	public Product() {
		super();
	}
	public Product(int productid, String name, int qoh, int price) {
		super();
		this.productid = productid;
		this.name = name;
		this.qoh = qoh;
		this.price = price;
	}
	public int getProductid() {
		return productid;
	}
	 public Product(int productid) {
		    this.productid = productid;
		    
		  }
	public void setProductid(int productid) {
		this.productid = productid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQoh() {
		return qoh;
	}
	public void setQoh(int qoh) {
		this.qoh = qoh;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Product [productid=" + productid + ", name=" + name + ", qoh=" + qoh + ", price=" + price + "]";
	}
	
	
	
}
