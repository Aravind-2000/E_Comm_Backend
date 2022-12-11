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
		return productRepository.availableProducts();
	}

	public Product getProduct(int pId) {
		return productRepository.geProduct(pId);
	}

	public String saveProduct(Product product) {
		product.setIsAvailable(1);
		productRepository.save(product);
		return "Product Added successfully";
	}

	public void deleteProduct(int pId) {
		Product product = productRepository.getReferenceById(pId);
		product.setIsAvailable(0);
		productRepository.save(product);
	}

	public String editProduct(int pid, Product newProduct) {
		Product oldProduct = productRepository.getReferenceById(pid);

		if (newProduct.getProductName() != null) {
			oldProduct.setProductName(newProduct.getProductName());
		}

		if (newProduct.getProductDescription() != null) {
			oldProduct.setProductDescription(oldProduct.getProductDescription());
		}

		if (newProduct.getProductCategoryId() != null) {
			oldProduct.setProductCategoryId(newProduct.getProductCategoryId());
		}

		if (newProduct.getProductPrice() != null) {
			oldProduct.setProductPrice(newProduct.getProductPrice());
		}

		if (newProduct.getProductImage() != null) {
			oldProduct.setProductImage(newProduct.getProductImage());
		}

		productRepository.save(oldProduct);
		return "Product Modified successfully";
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
