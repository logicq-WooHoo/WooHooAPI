package com.woho.vo;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.woho.model.PaymentDetails;

@JsonInclude(Include.NON_NULL)
public class RestaurantMenuVO {

	private Long restaurantId;
	/**
	 * Used in placeorder call
	 */
	private String restaurantName;
	/**
	 * Used in placeorder call
	 */
	private Long deliveryPartnerId;
	private String deliveryPartnerName;
	private Set<MenuItemVO> menuItems;

	@JsonIgnoreProperties(ignoreUnknown = true)
	PaymentDetails paymentDetails;

	public Long getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(Long restaurantId) {
		this.restaurantId = restaurantId;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public Long getDeliveryPartnerId() {
		return deliveryPartnerId;
	}

	public void setDeliveryPartnerId(Long deliveryPartnerId) {
		this.deliveryPartnerId = deliveryPartnerId;
	}

	public String getDeliveryPartnerName() {
		return deliveryPartnerName;
	}

	public void setDeliveryPartnerName(String deliveryPartnerName) {
		this.deliveryPartnerName = deliveryPartnerName;
	}

	public Set<MenuItemVO> getMenuItems() {
		return menuItems;
	}

	public void setMenuItems(Set<MenuItemVO> menuItems) {
		this.menuItems = menuItems;
	}

	public PaymentDetails getPaymentDetails() {
		return paymentDetails;
	}

	public void setPaymentDetails(PaymentDetails paymentDetails) {
		this.paymentDetails = paymentDetails;
	}

}
