package com.example.ecomm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecomm.entity.Product;
import com.example.ecomm.service.ProductService;

@RestController
@RequestMapping("/product")
@CrossOrigin
public class ProductController {

    @Autowired
    private ProductService productService;


    @GetMapping("/getall")
    public List<Product> getAll() {
        return productService.getAllProducts();
    }


    @PostMapping("/add")
    public String add(@RequestBody Product product){
        return productService.saveProduct(product);
    }
    
}
