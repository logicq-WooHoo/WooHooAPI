package com.woho.service;

import com.woho.model.MenuItem;
import com.woho.model.RestaurantMenu;

/**
 * 
 * @author Pankaj Labade
 *
 */
public interface RestaurantMenuService {
	RestaurantMenu getByMenuItem(MenuItem menuItem);
}
