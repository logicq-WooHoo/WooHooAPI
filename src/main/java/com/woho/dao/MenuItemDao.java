package com.woho.dao;

import java.util.List;

import com.woho.model.MenuItem;

/**
 * 
 * @author Pankaj Labade
 *
 */
public interface MenuItemDao {
	MenuItem getByFoodCategory(String foodCategory);
	List<MenuItem> getByFoodServiceTypes(List<String> foodServiceTypes);
}
