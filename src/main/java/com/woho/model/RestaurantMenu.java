package com.woho.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="RESTAURANT_MENU")
public class RestaurantMenu {
	
	private Long RESTAURANT_MENU_ID;
	
	private Set<MenuItem> menuItems;

	public Long getRESTAURANT_MENU_ID() {
		return RESTAURANT_MENU_ID;
	}

	public void setRESTAURANT_MENU_ID(Long rESTAURANT_MENU_ID) {
		RESTAURANT_MENU_ID = rESTAURANT_MENU_ID;
	}

	public Set<MenuItem> getMenuItems() {
		return menuItems;
	}

	public void setMenuItemsVO(Set<MenuItem> menuItems) {
		this.menuItems = menuItems;
	}
	
}
