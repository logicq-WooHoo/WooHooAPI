package com.woho.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.woho.dao.RestaurantDetailsFoodCategoryDao;
import com.woho.model.RestaurantDetailsFoodCategory;
import com.woho.service.RestaurantDetailsFoodCategoryService;

@Service
@Transactional
public class RestaurantDetailsFoodCategoryServiceImpl implements RestaurantDetailsFoodCategoryService {

	@Autowired
	RestaurantDetailsFoodCategoryDao restaurantDetailsFoodCategoryDao;

	@Override
	public List<RestaurantDetailsFoodCategory> getByFoodCategoryID(Long foodCategoryId) {
		return restaurantDetailsFoodCategoryDao.getByFoodCategoryID(foodCategoryId);
	}

}
