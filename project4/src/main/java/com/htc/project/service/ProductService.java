package com.htc.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.htc.project.converter.ProductConverter;
import com.htc.project.dto.ProductDTO;
import com.htc.project.model.Product;
import com.htc.project.repo.ProductRepository;

@Service("productService")
public class ProductService {
	

	@Autowired
	ProductRepository productRepository;
	@Autowired
	ProductConverter productConvertor;
	

	public boolean addProduct(ProductDTO product) {
		Product productObj=productConvertor.dtoToEntity(product);
		if(productRepository.save(productObj)!=null)
			return true;
		return false;
	}
	
	 public List<Product> getAllProducts(){
			return (List<Product>) productRepository.findAll();
		}
}
