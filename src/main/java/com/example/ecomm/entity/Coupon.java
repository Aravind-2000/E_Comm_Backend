package com.example.ecomm.entity;

import java.time.LocalDateTime;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity(name = "coupon")
@Getter
@Setter
public class Coupon {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private Integer userId;
	
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "userId",insertable = false, updatable = false)
	private User userDetails;
	
	private String couponCode;
	
	private Integer couponDiscount;
	
	@CreationTimestamp
	@JsonIgnore
	private LocalDateTime createdDateTime;
	
	@UpdateTimestamp
	@JsonIgnore
	private LocalDateTime modifiedDateTime;

	
	

}
