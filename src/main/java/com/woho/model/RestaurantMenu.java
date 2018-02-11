package com.woho.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="RESTAURANT_MENU")
public class RestaurantMenu {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "RESTAURANTMENUID")
	private Long restaurantMenuId;
	
	@OneToMany(cascade = CascadeType.ALL) 
	private Set<MenuItem> menuItems;
	
	public Long getRestaurantMenuId() {
		return restaurantMenuId;
	}

	public void setRestaurantMenuId(Long restaurantMenuId) {
		this.restaurantMenuId = restaurantMenuId;
	}

	public void setMenuItems(Set<MenuItem> menuItems) {
		this.menuItems = menuItems;
	}

	public Set<MenuItem> getMenuItems() {
		return menuItems;
	}
	
}
