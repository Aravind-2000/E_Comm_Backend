package com.example.ecomm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.ecomm.entity.Product;
import com.example.ecomm.entity.ProductCategory;
import com.example.ecomm.service.ProductCategoryService;
import com.example.ecomm.service.ProductService;

@RestController
@RequestMapping("/category")
@CrossOrigin
public class ProductCategoryController {

    @Autowired
    private ProductCategoryService productCategoryService;

    @Autowired
    private ProductService productService;

    @GetMapping("/getall")
    public List<ProductCategory> getAll() {
        return productCategoryService.getAllCategories();
    }

    @PostMapping("/add")
    public String add(@RequestBody ProductCategory category) {
        return productCategoryService.addCategory(category);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        List<Product> products = productService.getAllProducts();
        for (Product product : products) {
            if (product.getProductCategoryId() == id) {
                return ResponseEntity.badRequest()
                        .body("This category is associated with a product, so you cannot delete this.");
            }
        }
        return ResponseEntity.ok(productCategoryService.deleteCategory(id));
    }

    @PatchMapping("/edit/{id}")
    public ResponseEntity<?> editCategory(@PathVariable int id, @RequestBody ProductCategory category) {
        return ResponseEntity.ok(productCategoryService.editCategory(id, category));
    }

}
