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
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;

	@Column(name = "RESTAURANT_NAME")
	@NotNull
	@Size(max = 100)
	private String restaurantName;

	@Column(name = "REGISTRATION_NUMBER")
	@NotNull
	@Size(max = 100)
	private String registrationNumber;

	@Column(name = "PHONE")
	@Size(max = 20)
	private String phone;

	@Column(name = "WEBSITE")
	private String website;

	@OneToOne(cascade = CascadeType.ALL)
	private Address address;

	@OneToOne(cascade = CascadeType.ALL)
	private Document document;

	@ManyToOne
	private UserInformation userInformation;

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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}

	public UserInformation getUserInformation() {
		return userInformation;
	}

	public void setUserInformation(UserInformation userInformation) {
		this.userInformation = userInformation;
	}

	@Override
	public String toString() {
		return "RestaurantDetails [id=" + id + ", restaurantName=" + restaurantName + ", registrationNumber="
				+ registrationNumber + ", phone=" + phone + ", website=" + website + ", address=" + address
				+ ", document=" + document + ", userInformation=" + userInformation + "]";
	}
}
