package com.woho.dao;

import com.woho.model.MenuItem;
import com.woho.model.RestaurantMenu;

public interface RestaurantMenuDao {
	void addRestaurantMenu(RestaurantMenu restaurantMenu);
	RestaurantMenu getByMenuItem(MenuItem menuItem);
}
