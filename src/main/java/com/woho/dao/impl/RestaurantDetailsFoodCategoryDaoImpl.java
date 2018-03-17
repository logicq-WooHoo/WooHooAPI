package com.woho.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.woho.dao.AbstractDAO;
import com.woho.dao.RestaurantDetailsFoodCategoryDao;
import com.woho.model.RestaurantDetailsFoodCategory;

@Repository
public class RestaurantDetailsFoodCategoryDaoImpl extends AbstractDAO<RestaurantDetailsFoodCategory> implements RestaurantDetailsFoodCategoryDao {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6991546142723006150L;

	@Override
	public List<RestaurantDetailsFoodCategory> getByFoodCategoryID(Long foodCategoryId) {
		String query = "from RestaurantDetailsFoodCategory where foodCategoryId=" + foodCategoryId;
		return executeQuery(query);
	}

	
}
