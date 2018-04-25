package com.woho.vo;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.woho.model.Address;

@JsonInclude(Include.NON_NULL)
public class CartVO {
	@JsonIgnoreProperties(ignoreUnknown = true)
	Long userId;
	private Long addressId;
	private Address deliveryAddresses;
	private Set<RestaurantMenuVO> orderDetails;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getAddressId() {
		return addressId;
	}

	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}

	public Address getDeliveryAddresses() {
		return deliveryAddresses;
	}

	public void setDeliveryAddresses(Address deliveryAddresses) {
		this.deliveryAddresses = deliveryAddresses;
	}

	public Set<RestaurantMenuVO> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(Set<RestaurantMenuVO> orderDetails) {
		this.orderDetails = orderDetails;
	}
}
