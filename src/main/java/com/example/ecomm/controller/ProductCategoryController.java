package com.example.ecomm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.ecomm.entity.ProductCategory;
import com.example.ecomm.service.ProductCategoryService;

@RestController
@RequestMapping("/category")
@CrossOrigin
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

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable int id){
        return productCategoryService.deleteCategory(id);
    }

    @PatchMapping("/edit/{id}")
    public ResponseEntity<?> editCategory(@PathVariable int id, @RequestBody ProductCategory category){
        return ResponseEntity.ok(productCategoryService.editCategory(id, category));
    }

}
