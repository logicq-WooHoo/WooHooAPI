package com.woho.dao.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.woho.dao.AbstractDAO;
import com.woho.dao.RestaurantMenuDao;
import com.woho.model.MenuItem;
import com.woho.model.RestaurantMenu;

@Repository
public class RestaurantMenuDaoImpl extends AbstractDAO<RestaurantMenu> implements RestaurantMenuDao {

	/**
	 * 
	 */
	private static final long serialVersionUID = 60079151772709385L;

	@Override
	public void addRestaurantMenu(RestaurantMenu restaurantMenu) {
		save(restaurantMenu);
	}

	@Override
	public RestaurantMenu getByMenuItem(MenuItem menuItem) {
		List<MenuItem> menuItems = Arrays.asList(menuItem);
		String hql = "from RestaurantMenu where menuItems in (:list)";
		List<RestaurantMenu> restaurantMenus =  (List<RestaurantMenu>) executeQueryWithList(hql, menuItems);
		return restaurantMenus.get(0);
	}

}
