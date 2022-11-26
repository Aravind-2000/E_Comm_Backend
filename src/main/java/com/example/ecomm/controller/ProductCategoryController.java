package com.example.ecomm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecomm.entity.ProductCategory;
import com.example.ecomm.service.ProductCategoryService;


@RestController
@RequestMapping("/category")
@CrossOrigin(origins ="null", allowedHeaders = "*")
public class ProductCategoryController {
    

    @Autowired 
    private ProductCategoryService productCategoryService;


    @GetMapping("/getall")
    public List<ProductCategory> getAll() {
        return productCategoryService.getAllCategories();
    }

    @PostMapping("/add")
    public String add(@RequestBody ProductCategory category) {
        return productCategoryService.addCategory(category);
    }

}
