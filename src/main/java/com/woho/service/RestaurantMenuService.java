package com.woho.service;

import java.util.List;
import java.util.Set;

import com.woho.model.MenuItem;
import com.woho.model.RestaurantDetails;
import com.woho.model.RestaurantMenu;

/**
 * 
 * @author Pankaj Labade
 *
 */
public interface RestaurantMenuService {
	RestaurantMenu getByMenuItem(MenuItem menuItem);
	List<RestaurantMenu> getByMenuItems(Set<MenuItem> menuItems);
	RestaurantMenu getByRestaurantId(Long restaurantId);
	List<RestaurantMenu> getByMenuItemsAndRestaurantDetails(Set<MenuItem> menuItems, Set<RestaurantDetails> restaurantDetailsSet) throws Exception;
	Set<MenuItem> getMenuItemsByRestaurantId(Long restaurantId);
}
