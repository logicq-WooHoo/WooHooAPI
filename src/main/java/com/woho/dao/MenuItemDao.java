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
	/*MenuItem get(long id);
	List<MenuItem> list();
	void delete(long id);
	void update(long id, MenuItem menuItem);
	public boolean isMenuItemExist(MenuItem menuItem);*/
}
