package com.example.ecomm.entity;

import java.time.LocalDateTime;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity(name = "payment_details")
@Getter
@Setter
public class PaymentDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private Integer orderDetailsId;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "orderDetailsId", insertable = false, updatable = false)
	private OrderDetails orderDetails;
	
	private Integer paymentTypeId;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "paymentTypeId", insertable = false, updatable = false)
	private PaymentType paymentType;
	
	private Double payingAmount;
	
	private String status;
	
	@CreationTimestamp
	@JsonIgnore
	private LocalDateTime createdDateTime;
	
	@UpdateTimestamp
	@JsonIgnore
	private LocalDateTime modifiedDateTime;

}
