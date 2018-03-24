package com.woho.service;

import java.util.List;
import java.util.Set;

import com.woho.model.RestaurantType;

public interface RestaurantTypeService {

	Set<RestaurantType> getRestaurantTypeByID(Set<String> types);

	RestaurantType getById(Long id);

	void addRestaurentType(RestaurantType restaurentType);

	void deleteRestaurentType(RestaurantType restaurentType);

	void updateRestaurentType(RestaurantType restaurentType);

	List<RestaurantType> list();
}
