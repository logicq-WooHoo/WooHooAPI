package com.woho.dao;

import java.util.Set;

import com.woho.model.RestaurantType;

public interface RestaurantTypeDao {

	public Set<RestaurantType> getRestaurantTypeByID(Set<String> ids);
	
	void addRestaurentType(RestaurantType restaurentType);
	
	void deleteRestaurentType(RestaurantType restaurentType);
	
	void updateRestaurentType(RestaurantType restaurentTypes);
}