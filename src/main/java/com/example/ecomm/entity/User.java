package com.example.ecomm.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDateTime;

import javax.persistence.*;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "user")
@Getter
@Setter
@NoArgsConstructor
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;
	
	@Column(length = 20)
	private String userName;
	
	@JsonIgnore
	@Size(min = 8, max = 15)
	private String password;
	
	@Column(length = 20)
	private String userEmail;
	
	@Column(length = 10)
	private String userPhoneNumber;

	@Lob
	private String profilePicture;
	
	private Integer roleFlag;
	
	@CreationTimestamp
	@JsonIgnore
	private LocalDateTime createdDateTime;
	
	@UpdateTimestamp
	@JsonIgnore
	private LocalDateTime modifiedDateTime;

	public User(String userName,String password, String userEmail, String userPhoneNumber,
			Integer roleFlag, String profilePicture) {
		this.userName = userName;
		this.password = password;
		this.userEmail = userEmail;
		this.userPhoneNumber = userPhoneNumber;
		this.roleFlag = roleFlag;
		this.profilePicture = profilePicture;
	}


	
	
	
	
	
	

}
