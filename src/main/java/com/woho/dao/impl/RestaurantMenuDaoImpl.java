package com.woho.dao.impl;

import com.woho.dao.AbstractDAO;
import com.woho.dao.RestaurantMenuDao;
import com.woho.model.RestaurantMenu;

public class RestaurantMenuDaoImpl extends AbstractDAO<RestaurantMenu> implements RestaurantMenuDao{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void addRestaurantMenu(RestaurantMenu restaurantMenu) {
		save(restaurantMenu);
	}

}
