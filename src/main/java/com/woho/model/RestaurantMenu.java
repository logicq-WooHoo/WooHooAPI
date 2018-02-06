package com.woho.model;

import java.util.Set;

import javax.persistence.Entity;

import com.woho.vo.MenuItem;

@Entity
public class RestaurantMenu {
	
	private Set<FoodServiceType> foodServiceTypes;
	
	private Set<MenuItem> menuItems;

}
