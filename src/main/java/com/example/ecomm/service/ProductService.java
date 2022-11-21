package com.example.ecomm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecomm.entity.Product;
import com.example.ecomm.repository.ProductRepository;


@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	
	public List<Product> getAllProducts(){
		return productRepository.findAll();
	}
	
	public Product getProduct(int pId) {
		return productRepository.getReferenceById(pId);
	}
	
	public String saveProduct(Product product) {
		productRepository.save(product);
		return "Product Added successfully";
	}
	
	public String deleteProduct(int pId) {
		productRepository.deleteById(pId);
		return "Product deleted successfully";
	}
	
	

}
