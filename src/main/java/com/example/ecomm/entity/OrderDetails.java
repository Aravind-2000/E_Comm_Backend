package com.example.ecomm.entity;

import java.time.LocalDateTime;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity(name = "order_details")
@Getter
@Setter
public class OrderDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private Integer productId;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "productId", insertable = false, updatable = false)
	private Product productDetails;

	private String status;
	private Integer userId;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "userId", insertable = false, updatable = false)
	private User userDetails;

	private Integer quantity;

	private Double totalAmount;

	private String orderId;

	@CreationTimestamp
	@JsonIgnore
	private LocalDateTime createdDateTime;

	@UpdateTimestamp
	@JsonIgnore
	private LocalDateTime modifiedDateTime;

}
