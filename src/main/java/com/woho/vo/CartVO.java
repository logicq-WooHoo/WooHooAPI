package com.woho.vo;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.woho.model.PaymentDetails;

public class CartVO {
	private Set<RestaurantMenuVO> orderDetails;
	private String deliveryAddress;
	/**
	 * Used in placeorder call, only to store in DB
	 */
	@JsonIgnoreProperties(ignoreUnknown = true)
	PaymentDetails paymentDetails;

	@JsonIgnoreProperties(ignoreUnknown = true)
	Long userId;

	public Set<RestaurantMenuVO> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(Set<RestaurantMenuVO> orderDetails) {
		this.orderDetails = orderDetails;
	}

	public String getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public PaymentDetails getPaymentDetails() {
		return paymentDetails;
	}

	public void setPaymentDetails(PaymentDetails paymentDetails) {
		this.paymentDetails = paymentDetails;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

}
