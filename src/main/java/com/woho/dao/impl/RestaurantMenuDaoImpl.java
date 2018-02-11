package com.woho.dao.impl;

import org.springframework.stereotype.Repository;
import com.woho.dao.AbstractDAO;
import com.woho.dao.RestaurantMenuDao;
import com.woho.model.RestaurantMenu;

@Repository
public class RestaurantMenuDaoImpl extends AbstractDAO<RestaurantMenu> implements RestaurantMenuDao{

	/**
	 * 
	 */
	private static final long serialVersionUID = 60079151772709385L;

	@Override
	public void addRestaurantMenu(RestaurantMenu restaurantMenu) {
		save(restaurantMenu);
	}

}
