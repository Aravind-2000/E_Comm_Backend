package com.example.ecomm.entity;

import javax.persistence.Entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDateTime;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity(name = "address")
@Getter
@Setter
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private Integer userId;
	
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "userId",insertable = false, updatable = false)
	private User userDetails;
	
	private String addressLine1;
	
	private String addressLine2;
	
	private String city;
	
	private String state;
	
	private String pincode;
	
	private String country;
	
	@CreationTimestamp
	@JsonIgnore
	private LocalDateTime createdDateTime;
	
	@UpdateTimestamp
	@JsonIgnore
	private LocalDateTime modifiedDateTime;
	
	

}
