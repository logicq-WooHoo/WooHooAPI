package com.woho.model;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "ORDER_TRACKING")
public class OrderTracking {

	/**
	 * Tracking id : Randomly generated alphanumeric string
	 */
	@Id
	@Column(name = "ID", nullable = false)
	private String id;

	@OneToOne
	@NotNull
	private RestaurantDetails restaurantDetails;

	@Lob
	@Column(name = "ORDER_JSON", nullable = false)
	private byte[] orderJson;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public RestaurantDetails getRestaurantDetails() {
		return restaurantDetails;
	}

	public void setRestaurantDetails(RestaurantDetails restaurantDetails) {
		this.restaurantDetails = restaurantDetails;
	}

	public byte[] getOrderJson() {
		return orderJson;
	}

	public void setOrderJson(byte[] orderJson) {
		this.orderJson = orderJson;
	}

}
