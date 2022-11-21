package com.example.ecomm.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignupRequest {

    private String email;
	
	private String username;
	
	private String phoneNumber;
	
	private int roleFlag;
	
	private String password;

	private String profilePicture;
    
}
