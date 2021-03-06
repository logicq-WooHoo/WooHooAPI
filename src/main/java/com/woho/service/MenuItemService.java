package com.woho.service;

import java.util.List;

import com.woho.model.MenuItem;

/**
 * 
 * @author Pankaj Labade
 *
 */
public interface MenuItemService {
	MenuItem getByFoodCategory(String foodCategory);

	List<MenuItem> getByFoodServiceTypes(List<String> foodServiceTypes);

	List<MenuItem> getByIds(List<Long> ids);

	MenuItem get(Long id);

	List<MenuItem> findByMenuItem(String menuItem);
}
