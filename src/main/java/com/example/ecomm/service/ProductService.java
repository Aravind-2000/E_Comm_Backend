package com.example.ecomm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecomm.entity.Cart;
import com.example.ecomm.entity.Product;
import com.example.ecomm.repository.CartRepository;
import com.example.ecomm.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private CartRepository cartRepository;

	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	public Product getProduct(int pId) {
		return productRepository.geProduct(pId);
	}

	public String saveProduct(Product product) {
		productRepository.save(product);
		return "Product Added successfully";
	}

	public String deleteProduct(int pId) {
		productRepository.deleteById(pId);
		return "Product deleted successfully";
	}

	public String addProductToCart(int productId, int cartId) {
		if (cartRepository.findById(cartId).isPresent()) {
			if (productRepository.findById(productId).isPresent()) {
				Product product = productRepository.getReferenceById(productId);
				Cart cart = cartRepository.getReferenceById(cartId);
				if (!product.getAddedCarts().contains(cart)) {
					product.addProduct(cart);
					productRepository.save(product);
					return "Product Added in cart Successfully";
				} else {
					return "Product Already in cart";
				}
			}
		}
		return "Product not found";
	}

	public String removeProductFromCart(int productId, int cartId) {
		Product product = productRepository.getReferenceById(productId);
		Cart cart = cartRepository.getReferenceById(cartId);
		product.removeProduct(cart);
		productRepository.save(product);
		return "Product Removed from cart successfully";
	}

}
