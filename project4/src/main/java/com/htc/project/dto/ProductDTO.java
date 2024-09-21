package com.htc.project.dto;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


public class ProductDTO {
	@Nonnull
	@Min(1000)
	@Max(1100)
	private int productid;
	@NotBlank(message="Name required")
	@Size(min=2,max=12,message="name must be between 2 and 12 character long")
	private String name;
	@Nonnull
	@Min(0)
	@Max(1000)
	private int qoh;
	private int price;
	public ProductDTO(@Min(1000) @Max(1100) int productid,
			@NotBlank(message = "Name required") @Size(min = 2, max = 12, message = "name must be between 2 and 12 character long") String name,
			@Min(0) @Max(1000) int qoh, int price) {
		super();
		this.productid = productid;
		this.name = name;
		this.qoh = qoh;
		this.price = price;
	}
	public ProductDTO() {
		super();
	}
	public int getProductid() {
		return productid;
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
	

	
}
