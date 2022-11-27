package com.example.ecomm.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;
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

	private String couponCode;

	private Integer couponDiscount;

	@JsonFormat(pattern = "MM-dd-yyyy")
	private LocalDate expiryDate;

	private Integer eventId;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "eventId", insertable = false, updatable = false)
	private Event eventDetails;

	@CreationTimestamp
	@JsonIgnore
	private LocalDateTime createdDateTime;

	@UpdateTimestamp
	@JsonIgnore
	private LocalDateTime modifiedDateTime;

}
