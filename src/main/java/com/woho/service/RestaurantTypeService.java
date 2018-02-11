package com.woho.service;

import java.util.Set;

import com.woho.model.RestaurantType;

public interface RestaurantTypeService {
	
	Set<RestaurantType> getRestaurantTypeByID(Set<String> types);
	
	void addRestaurentType(RestaurantType restaurentType);
	
	void deleteRestaurentType(RestaurantType restaurentType);
	
	void updateRestaurentType(RestaurantType restaurentType);

}
