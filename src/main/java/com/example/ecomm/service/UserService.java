package com.example.ecomm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecomm.entity.Cart;
import com.example.ecomm.entity.SignupRequest;
import com.example.ecomm.entity.User;
import com.example.ecomm.repository.CartRepository;
import com.example.ecomm.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private CartRepository cartRepository;

	public User loginService(String email, String password) {
		User user = userRepository.login(email, password);
		if (user != null) {
			return user;
		} else {
			return null;
		}
	}

	public String signupServiceCustomer(SignupRequest signupRequest) {

		if (userRepository.existsByUserEmail(signupRequest.getEmail())) {
			return "Email already exists";
		}

		else {

			User user = new User(signupRequest.getUsername(), signupRequest.getPassword(),
					signupRequest.getEmail(), signupRequest.getPhoneNumber(), 0, signupRequest.getProfilePicture());
			userRepository.save(user);
			Cart cart = new Cart(user.getUserId());
			cartRepository.save(cart);
			return "Customer added";
		}

	}

	public String signupService(SignupRequest signupRequest) {
		if (userRepository.existsByUserEmail(signupRequest.getEmail())) {
			return "Email already exists";
		}

		else {

			User user = new User(signupRequest.getUsername(), signupRequest.getPassword(),
					signupRequest.getEmail(), signupRequest.getPhoneNumber(), 1, signupRequest.getProfilePicture());
			userRepository.save(user);
			Cart cart = new Cart(user.getUserId());
			cartRepository.save(cart);
			return "Admin added";
		}
	}

	public String deleteUserService(int userId) {
		userRepository.deleteById(userId);
		return "User deleted successfully";
	}

	public String encryptPassword(String pass) {

		String encryptedPassword = "";

		return encryptedPassword;
	}

	public String decryptPassword(String pass) {

		String originalPassword = "";

		return originalPassword;
	}
}
