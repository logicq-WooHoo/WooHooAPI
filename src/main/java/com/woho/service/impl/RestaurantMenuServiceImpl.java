package com.woho.service.impl;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import com.woho.dao.RestaurantMenuDao;
import com.woho.model.FoodCategory;
import com.woho.model.FoodServiceType;
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
	public RestaurantMenu getByRestaurantId(Long restaurantId) {
		return restaurantMenuDao.getByRestaurantId(restaurantId);
	}

	@Override
	public List<RestaurantMenu> getByMenuItemsAndRestaurantDetails(Set<MenuItem> menuItems,
			Set<RestaurantDetails> restaurantDetailsSet) throws Exception {
		return restaurantMenuDao.getByMenuItemsAndRestaurantDetails(menuItems, restaurantDetailsSet);
	}

	@Override
	public Set<MenuItem> getMenuItemsByRestaurantId(Long restaurantId) {
		RestaurantMenu restaurantMenu = getByRestaurantId(restaurantId);
		if (null != restaurantMenu) {
			return restaurantMenu.getMenuItems();
		}
		return null;
	}

	@Override
	public List<RestaurantMenu> getByMenuItems(Set<MenuItem> menuItems) {
		return restaurantMenuDao.getByMenuItems(menuItems);
	}

	@Override
	public Set<FoodCategory> getFoodCategories(Long restaurantId) {
		RestaurantMenu restaurantMenu = getByRestaurantId(restaurantId);
		if (!ObjectUtils.isEmpty(restaurantMenu)) {
			return restaurantMenu.getFoodCategories();
		}
		return null;
	}

	@Override
	public Set<FoodServiceType> getFoodServiceTypes(Long restaurantId) {
		RestaurantMenu restaurantMenu = getByRestaurantId(restaurantId);
		if (!ObjectUtils.isEmpty(restaurantMenu)) {
			return restaurantMenu.getFoodServiceTypes();
		}
		return null;
	}

	@Override
	public Set<String> getFoodCategoryNames(Long restaurantId) {
		Set<FoodCategory> foodCategories = getFoodCategories(restaurantId);
		if (!CollectionUtils.isEmpty(foodCategories)) {
			return foodCategories.stream().map(fc -> fc.getCategory()).collect(Collectors.toSet());
		}
		return null;
	}

	@Override
	public Set<String> getFoodServiceTypeNames(Long restaurantId) {
		Set<FoodServiceType> foodServiceTypes = getFoodServiceTypes(restaurantId);
		if (!CollectionUtils.isEmpty(foodServiceTypes)) {
			return foodServiceTypes.stream().map(fct -> fct.getServiceType()).collect(Collectors.toSet());
		}
		return null;
	}

}
