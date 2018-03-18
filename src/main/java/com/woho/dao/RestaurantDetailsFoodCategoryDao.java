package com.woho.dao;

import java.util.List;

import com.woho.model.RestaurantDetailsFoodCategory;

public interface RestaurantDetailsFoodCategoryDao {
	
	List<RestaurantDetailsFoodCategory> getByFoodCategoryID(Long foodCategoryId);
	
}
