package com.woho.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

@Entity
public class Address {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Size(max = 100)
	@Column(name = "FLAT_NO")
	private String flatNo;

	@Size(max = 100)
	@Column(name = "SOCIETY_NAME")
	private String societyName;

	@Size(max = 100)
	@Column(name = "STREET")
	private String street;

	@Size(max = 100)
	@Column(name = "ROAD")
	private String road;

	@Column(name = "LOCALITY")
	@Size(max = 100)
	private String locality;

	@Size(max = 100)
	@Column(name = "LANDMARK")
	private String landmark;

	@Size(max = 100)
	@Column(name = "CITY")
	private String city;

	@Size(max = 100)
	@Column(name = "STATE")
	private String state;

	@Size(max = 100)
	@Column(name = "COUNTY")
	private String country;

	@Column(name = "PINCODE", nullable = false, columnDefinition = "bigint(20) default 0")
	private Long pinCode;

	/*
	 * @Column(name = "POINT") private Point point;
	 */

	@Size(max = 100)
	@Column(name = "ADDRESS_TYPE")
	private String type;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userId")
	private UserInformation user;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFlatNo() {
		return flatNo;
	}

	public void setFlatNo(String flatNo) {
		this.flatNo = flatNo;
	}

	public String getSocietyName() {
		return societyName;
	}

	public void setSocietyName(String societyName) {
		this.societyName = societyName;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getRoad() {
		return road;
	}

	public void setRoad(String road) {
		this.road = road;
	}

	public String getLocality() {
		return locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Long getPinCode() {
		return pinCode;
	}

	public void setPinCode(Long pinCode) {
		this.pinCode = pinCode;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public UserInformation getUser() {
		return user;
	}

	public void setUser(UserInformation user) {
		this.user = user;
	}
	
}
