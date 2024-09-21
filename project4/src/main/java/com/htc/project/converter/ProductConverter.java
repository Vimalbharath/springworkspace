package com.htc.project.converter;






import org.springframework.beans.BeanUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.htc.project.dto.ProductDTO;
import com.htc.project.model.Product;




@Component
public class ProductConverter {
	
	
	
	
	
	
	public Product dtoToEntity(ProductDTO user)
	{
		Product obj=new Product();
		BeanUtils.copyProperties(user, obj);
		return obj;	
		
	}
	
	public ProductDTO entityToDto(Product user)
	{
		ProductDTO obj=new ProductDTO();
		BeanUtils.copyProperties(user, obj);
		return obj;	
		
	}
	
	
	
	

}
