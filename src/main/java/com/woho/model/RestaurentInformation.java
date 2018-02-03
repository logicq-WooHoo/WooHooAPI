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
	private Long hotel_id;
	
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

	public Long getHotel_id() {
		return hotel_id;
	}

	public void setHotel_id(Long hotel_id) {
		this.hotel_id = hotel_id;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	//documents
	
	//user id many to one relationship

	
	
}
