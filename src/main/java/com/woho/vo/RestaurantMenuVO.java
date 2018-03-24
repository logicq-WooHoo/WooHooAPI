package com.woho.vo;

import java.util.Set;

public class RestaurantMenuVO {
	
	private Long restaurantId;
	private Set<MenuItemVO> menuItems;
	
	public Long getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(Long restaurantId) {
		this.restaurantId = restaurantId;
	}
	public Set<MenuItemVO> getMenuItems() {
		return menuItems;
	}
	public void setMenuItems(Set<MenuItemVO> menuItems) {
		this.menuItems = menuItems;
	}
	
	@Override
	public String toString() {
		return "RestaurantMenuVO [restaurantId=" + restaurantId + ", menuItems=" + menuItems + "]";
	}
	
}
