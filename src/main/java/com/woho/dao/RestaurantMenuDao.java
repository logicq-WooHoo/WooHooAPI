package com.woho.dao;

import java.util.List;
import java.util.Set;

import com.woho.model.MenuItem;
import com.woho.model.RestaurantDetails;
import com.woho.model.RestaurantMenu;

public interface RestaurantMenuDao {
	void addRestaurantMenu(RestaurantMenu restaurantMenu);
	RestaurantMenu getByMenuItem(MenuItem menuItem);
	RestaurantMenu getByRestaurantId(Long restaurantId);
	List<RestaurantMenu> getByMenuItemsAndRestaurantDetails(Set<MenuItem> menuItems, Set<RestaurantDetails> restaurantDetailsSet) throws Exception;
}
