package com.woho.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * 
 * @author Pankaj Labade
 *
 */
@Entity
@Table(name = "ORDER_DETAILS")
public class OrderDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;

	@Lob
	@Column(name = "ORDER_JSON", nullable = false)
	private byte[] orderJson;

	@OneToOne
	@NotNull
	private RestaurantDetails restaurantDetails;

	@OneToOne(cascade = CascadeType.ALL) 
	private Address deliveryAddresses;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public byte[] getOrderJson() {
		return orderJson;
	}

	public void setOrderJson(byte[] orderJson) {
		this.orderJson = orderJson;
	}

	public RestaurantDetails getRestaurantDetails() {
		return restaurantDetails;
	}

	public void setRestaurantDetails(RestaurantDetails restaurantDetails) {
		this.restaurantDetails = restaurantDetails;
	}

	public Address getDeliveryAddresses() {
		return deliveryAddresses;
	}

	public void setDeliveryAddresses(Address deliveryAddresses) {
		this.deliveryAddresses = deliveryAddresses;
	}
	
}
