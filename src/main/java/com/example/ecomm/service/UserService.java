package com.example.ecomm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.ecomm.entity.Cart;
import com.example.ecomm.entity.SignupRequest;
import com.example.ecomm.entity.User;
import com.example.ecomm.repository.CartRepository;
import com.example.ecomm.repository.UserRepository;

import java.util.List;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private CartRepository cartRepository;


	public List<User> getUsers(){
		return userRepository.findAll();
	}

	public User loginService(String email, String password) {
		User user = userRepository.login(email, password);
		if (user != null) {
			return user;
		} else {
			return null;
		}
	}

	public ResponseEntity<?> signupServiceCustomer(SignupRequest signupRequest) {

		if (userRepository.existsByUserEmailAndRoleFlag(signupRequest.getEmail(), 0)) {
			return ResponseEntity.badRequest().body("Email already exists");
		}

		else {

			User user = new User(signupRequest.getUsername(), signupRequest.getPassword(),
					signupRequest.getEmail(), signupRequest.getPhoneNumber(), 0, signupRequest.getProfilePicture());
			userRepository.save(user);
			Cart cart = new Cart(user.getUserId());
			cartRepository.save(cart);
			return ResponseEntity.ok("Customer added");
		}

	}

	public ResponseEntity<?> signupService(SignupRequest signupRequest) {
		if (userRepository.existsByUserEmailAndRoleFlag(signupRequest.getEmail(), 1)) {
			return ResponseEntity.badRequest().body("Email already exists");
		}

		else {

			User user = new User(signupRequest.getUsername(), signupRequest.getPassword(),
					signupRequest.getEmail(), signupRequest.getPhoneNumber(), 1, signupRequest.getProfilePicture());
			userRepository.save(user);
			// Cart cart = new Cart(user.getUserId());
			// cartRepository.save(cart);
			return ResponseEntity.ok("Customer added");
		}
	}

	public String deleteUserService(int userId) {
		userRepository.deleteById(userId);
		return "User deleted successfully";
	}

}
