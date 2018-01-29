package com.woho.model;

import java.awt.Point;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Address {
	
	@Id
	@Column
	private String Id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private UserInformation user;
	
	@Column
	@NotNull
	private int houseNo;
	
	@NotNull
	@Size(max = 100)
	@Column
	private String societyName;
	
	@NotNull
	@Size(max = 100)
	@Column
	private String streetName;
	
	@NotNull
	@Size(max = 100)
	@Column
	private String roadName;
	
	@NotNull
	@Size(max = 100)
	@Column
	private String city;
	
	@Column
	private long pinCode;
	
	@NotNull
	@Size(max = 100)
	@Column
	private String country;
	
	@NotNull
	@Column
	private long zipCode;
	
	private Point point;

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public UserInformation getUser() {
		return user;
	}

	public void setUser(UserInformation user) {
		this.user = user;
	}

	public int getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(int houseNo) {
		this.houseNo = houseNo;
	}

	public String getSocietyName() {
		return societyName;
	}

	public void setSocietyName(String societyName) {
		this.societyName = societyName;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getRoadName() {
		return roadName;
	}

	public void setRoadName(String roadName) {
		this.roadName = roadName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public long getPinCode() {
		return pinCode;
	}

	public void setPinCode(long pinCode) {
		this.pinCode = pinCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public long getZipCode() {
		return zipCode;
	}

	public void setZipCode(long zipCode) {
		this.zipCode = zipCode;
	}
}
