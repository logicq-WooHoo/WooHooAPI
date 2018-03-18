package com.woho.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class RestaurantSetup {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="SETUP_ID")
	private Long id;
		
	@ManyToMany(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
	@JoinTable(name = "RESTAURANTSETUP_RESTAURANTTYPE", joinColumns = @JoinColumn(name = "SETUP_ID"), inverseJoinColumns = @JoinColumn(name = "ID"))	
	private Set<RestaurantType> restTypes;
	

	@ManyToMany(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
	@JoinTable(name = "RESTAURANTSETUP_DELIVERYPARTNER", joinColumns = @JoinColumn(name = "SETUP_ID"), inverseJoinColumns = @JoinColumn(name = "ID"))
	private Set<DeliveryPartner> deliveryPartners;
	
	@Lob
	@Column(name = "OPERATION_TIME",nullable = false)
	private byte[] operationTime;
	
	@Lob
	@Column(name = "DELIVERY_SERVICES",nullable = false)
	private byte[] deliveryServices;
	
	@OneToOne
	private RestaurantDetails restaurantDetails;
	
	public RestaurantDetails getRestaurantDetails() {
		return restaurantDetails;
	}

	public void setRestaurantDetails(RestaurantDetails restaurantDetails) {
		this.restaurantDetails = restaurantDetails;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<RestaurantType> getRestTypes() {
		return restTypes;
	}

	public void setRestTypes(Set<RestaurantType> restTypes) {
		this.restTypes = restTypes;
	}

	public Set<DeliveryPartner> getDeliveryPartners() {
		return deliveryPartners;
	}

	public void setDeliveryPartners(Set<DeliveryPartner> deliveryPartners) {
		this.deliveryPartners = deliveryPartners;
	}

	public byte[] getOperationTime() {
		return operationTime;
	}

	public void setOperationTime(byte[] operationTime) {
		this.operationTime = operationTime;
	}

	public byte[] getDeliveryServices() {
		return deliveryServices;
	}

	public void setDeliveryServices(byte[] deliveryServices) {
		this.deliveryServices = deliveryServices;
	}
	
	
}
