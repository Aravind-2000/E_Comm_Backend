package com.example.ecomm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecomm.entity.ProductCategory;
import com.example.ecomm.repository.ProductCategoryRepository;

@Service
public class ProductCategoryService {
	
	@Autowired
	private ProductCategoryRepository categoryRepository;
	
	
	
	public List<ProductCategory> getAllCategories(){
       return categoryRepository.findAll();
	}

	
	public ProductCategory getCategory(int id) {
		return categoryRepository.getReferenceById(id);
	}
	
	public String addCategory(ProductCategory category) {
		categoryRepository.save(category);
		return "Added successfully";
	}
	
	public String deleteCategory(int id) {
		categoryRepository.deleteById(id);
		return "Deleted Successfully";
	}
}
