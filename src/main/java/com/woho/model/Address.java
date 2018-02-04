package com.woho.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="ADDRESS")
public class Address {
	
	@Id
	@Column(name="ADDRESS_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Size(max = 100)
	@Column(name="FLAT_NO")
	private String flatNo;
	
	@Size(max = 100)
	@Column(name="SOCIETY_NAME")
	private String societyName;
	
	@Size(max = 100)
	@Column(name="STREET")
	private String street;
	
	@Size(max = 100)
	@Column(name="ROAD")
	private String road;
	
	@Size(max = 100)
	@Column(name="CITY")
	private String city;
	
	@NotNull
	@Size(min=4,max=10)
	@Column(name="PIN_CODE")
	private String pinCode;
	
	@Size(max = 100)
	@Column(name="COUNTY")
	private String country;
	
	@Column(name="LOCALITY")
	@Size(max = 100)
	private String locality;
	
	@Size(max = 100)
	@Column(name="LANDMARK")
	private String landmark;
	
	@Size(max = 100)
	@Column(name="ADDRESS_TYPE")
	private String type;

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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
