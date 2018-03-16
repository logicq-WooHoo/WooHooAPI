package com.woho.service;

import com.woho.model.MenuItem;

/**
 * 
 * @author Pankaj Labade
 *
 */
public interface MenuItemService {
	MenuItem getByFoodCategory(String foodCategory);
}
