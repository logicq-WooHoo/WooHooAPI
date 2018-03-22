package com.woho.dao;

import com.woho.model.RestaurantSetup;

public interface RestaurantSetupDao {

	void addRestaurantSetup(RestaurantSetup restaurantSetup);

	RestaurantSetup getByRestaurantId(Long restaurantId);
}
