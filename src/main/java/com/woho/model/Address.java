package com.woho.model;

import java.awt.Point;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Address {
	
	@Id
	@Column(name="ADDRESS_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userId")
	private UserInformation user;
	
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
	@Column(name="PIN_CODE")
	@Size(max = 100)
	private long pinCode;
	
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
	@Column(name="POINT")
	private Point point;
	
	@Size(max = 100)
	@Column(name="ADDRESS_TYPE")
	private String type;
	
}
