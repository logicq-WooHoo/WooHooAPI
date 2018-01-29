package com.woho.model;

import java.awt.Point;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class RestaurentInformation {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="hotel_id")
	private String hotel_id;
	
	@Column(name="restaurantName")
	@NotNull
	@Size(max = 100)
	private String restaurantName;
	
	@Column(name="registrationNumber")
	@NotNull
	@Size(max = 100)
	private String registrationNumber;
	
	@OneToOne
	private Address address;
	
	//documents
	
	//user id many to one relationship

	
}
