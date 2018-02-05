package com.woho.service;

import java.util.Set;

import com.woho.model.RestaurentType;

public interface RestaurentTypeService {
	
	Set<RestaurentType> getRestaurantTypeByID(Set<String> types);

}
