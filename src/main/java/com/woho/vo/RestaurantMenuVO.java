package com.woho.vo;

import java.util.Set;

public class RestaurantMenuVO {

	private Long restaurantId;
	/**
	 * Used in placeorder call
	 */
	private String restaurantName;
	/**
	 * Used in placeorder call
	 */
	private String deliveryPartner;
	private Set<MenuItemVO> menuItems;

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

	public String getDeliveryPartner() {
		return deliveryPartner;
	}

	public void setDeliveryPartner(String deliveryPartner) {
		this.deliveryPartner = deliveryPartner;
	}

	public Set<MenuItemVO> getMenuItems() {
		return menuItems;
	}

	public void setMenuItems(Set<MenuItemVO> menuItems) {
		this.menuItems = menuItems;
	}

	@Override
	public String toString() {
		return "RestaurantMenuVO [restaurantId=" + restaurantId + ", restaurantName=" + restaurantName
				+ ", deliveryPartner=" + deliveryPartner + ", menuItems=" + menuItems + "]";
	}
}
