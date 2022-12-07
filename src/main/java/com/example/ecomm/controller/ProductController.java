package com.example.ecomm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public String add(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        productService.deleteProduct(id);
        return "Product Deleted";
    }

    @GetMapping("/get/{id}")
    public Product get(@PathVariable int id) {
        return productService.getProduct(id);
    }

    @PutMapping("/addtocart/{productid}/{cartid}")
    public ResponseEntity<?> addToCart(@PathVariable int productid, @PathVariable int cartid) {
        return ResponseEntity.ok(productService.addProductToCart(productid, cartid));
    }

    @DeleteMapping("/removefromcart/{productid}/{cartid}")
    public ResponseEntity<?> removeFromCart(@PathVariable int productid, @PathVariable int cartid) {
        return ResponseEntity.ok(productService.removeProductFromCart(productid, cartid));
    }

    @PatchMapping("/edit/{id}")
    public ResponseEntity<?> editProduct(@PathVariable int id, @RequestBody Product product){
        return ResponseEntity.ok(productService.editProduct(id, product));
    }

}
