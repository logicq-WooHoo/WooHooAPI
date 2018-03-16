package com.woho.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 
 * @author Pankaj Labade
 *
 */
@Entity
@Table(name = "RESTAURANT_DETAILS")
public class RestaurantDetails {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	private Long id;
	
	@Column(name="RESTAURANT_NAME")
	@NotNull
	@Size(max = 100)
	private String restaurantName;
	
	@Column(name="REGISTRATION_NUMBER")
	@NotNull
	@Size(max = 100)
	private String registrationNumber;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Address address;

	//documents
	
	//user id many to one relationship

	@ManyToOne
	private UserInformation userInformation;
	
	@Column(name="DOCUMENT_PATH")
	@Size(max = 100)
	private String documentPath;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public UserInformation getUserInformation() {
		return userInformation;
	}

	public void setUserInformation(UserInformation userInformation) {
		this.userInformation = userInformation;
	}

	public String getDocumentPath() {
		return documentPath;
	}

	public void setDocumentPath(String documentPath) {
		this.documentPath = documentPath;
	}
  	
}
