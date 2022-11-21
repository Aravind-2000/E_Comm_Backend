package com.example.ecomm.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDateTime;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity(name = "product_category")
@Getter
@Setter
public class ProductCategory {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length = 20)
	private String categoryName;
	
	@Column(length = 100)
	private String categoryDescription;
	
	@CreationTimestamp
	@JsonIgnore
	private LocalDateTime createdDateTime;
	
	@UpdateTimestamp
	@JsonIgnore
	private LocalDateTime modifiedDateTime;
	

}
