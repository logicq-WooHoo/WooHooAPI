package com.woho.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 
 * @author Pankaj Labade
 *
 */
@Entity
@Table(name = "HOTEL_DETAILS")
public class HotelDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;

	@Column(name = "HOTEL_NAME")
	@NotNull
	@Size(max = 100)
	private String hotelName;

	@Column(name = "REGISTRATION_NUMBER")
	@Size(max = 100)
	private String registrationNumber;

	@Column(name = "PHONE")
	@Size(max = 20)
	private String phone;

	@Column(name = "WEBSITE")
	private String website;

	@Lob
	@Column(name = "OUT_SERVICES")
	private byte[] outServices;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Address address;

	@OneToOne(cascade = CascadeType.ALL)
	private HotelType type;

	@OneToOne(cascade = CascadeType.ALL)
	private Document document;

	@ManyToOne
	private UserInformation userInformation;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnore
	private Set<Amenity> amenities;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
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

	public byte[] getOutServices() {
		return outServices;
	}

	public void setOutServices(byte[] outServices) {
		this.outServices = outServices;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public HotelType getType() {
		return type;
	}

	public void setType(HotelType type) {
		this.type = type;
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

	public Set<Amenity> getAmenities() {
		return amenities;
	}

	public void setAmenities(Set<Amenity> amenities) {
		this.amenities = amenities;
	}

}
