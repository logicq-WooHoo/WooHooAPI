package com.woho.service.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.woho.dao.RestaurantMenuDao;
import com.woho.model.MenuItem;
import com.woho.model.RestaurantDetails;
import com.woho.model.RestaurantMenu;
import com.woho.service.RestaurantMenuService;

/**
 * 
 * @author Pankaj Labade
 *
 */

@Service
@Transactional
public class RestaurantMenuServiceImpl implements RestaurantMenuService {

	@Autowired
	RestaurantMenuDao restaurantMenuDao;

	@Override
	@Transactional(readOnly = true)
	public RestaurantMenu getByMenuItem(MenuItem menuItem) {
		return restaurantMenuDao.getByMenuItem(menuItem);
	}

	@Override
	public List<RestaurantMenu> getByMenuItemsAndRestaurantDetails(Set<MenuItem> menuItems, Set<RestaurantDetails> restaurantDetailsSet)
			throws Exception {
		return restaurantMenuDao.getByMenuItemsAndRestaurantDetails(menuItems, restaurantDetailsSet);
	}

}
