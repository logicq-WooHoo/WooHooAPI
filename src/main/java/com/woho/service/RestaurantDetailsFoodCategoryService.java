package com.woho.service;

import java.util.List;

import com.woho.model.RestaurantDetailsFoodCategory;

public interface RestaurantDetailsFoodCategoryService {
	
	List<RestaurantDetailsFoodCategory> getByFoodCategoryID(Long foodCategoryId);
}
