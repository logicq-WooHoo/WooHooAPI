package com.woho.vo;

import java.util.Map;

import com.woho.model.Address;

/**
 * 
 * @author Pankaj Labade
 *
 */
public class OrderDetailsVO {

	private Long id;

	private Map<String, Object> orderJson;

	private Long restaurantId;

	private Address deliveryAddresses;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Map<String, Object> getOrderJson() {
		return orderJson;
	}

	public void setOrderJson(Map<String, Object> orderJson) {
		this.orderJson = orderJson;
	}

	public Long getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(Long restaurantId) {
		this.restaurantId = restaurantId;
	}

	public Address getDeliveryAddresses() {
		return deliveryAddresses;
	}

	public void setDeliveryAddresses(Address deliveryAddresses) {
		this.deliveryAddresses = deliveryAddresses;
	}

	@Override
	public String toString() {
		return "OrderDetailsVO [id=" + id + ", orderJson=" + orderJson + ", restaurantId=" + restaurantId
				+ ", deliveryAddresses=" + deliveryAddresses + "]";
	}

}
