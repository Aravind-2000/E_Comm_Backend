package com.example.ecomm.entity;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity(name = "product")
@Getter
@Setter
public class Product {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer productId;
	
	@Column(length = 20)
	private String productName;
	
	@Lob
	private String productImage;
	
	private Double productPrice;
	
	@Column(length = 100)
	private String productDescription;
	
	private Integer noOfProducts;
	
	private Integer productCategoryId;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "productCategoryId", insertable = false, updatable = false)
	private ProductCategory productCategory;
	
	@CreationTimestamp
	@JsonIgnore
	private LocalDateTime createdDateTime;
	
	@UpdateTimestamp
	@JsonIgnore
	private LocalDateTime modifiedDateTime;
	

}
