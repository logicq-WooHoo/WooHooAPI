package com.woho.dao;

import com.woho.model.MenuItem;

/**
 * 
 * @author Pankaj Labade
 *
 */
public interface MenuItemDao {
	MenuItem getByFoodCategory(String foodCategory);
}
