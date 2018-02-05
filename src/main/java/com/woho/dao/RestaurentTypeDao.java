package com.woho.dao;

import java.util.Set;

import com.woho.model.RestaurentType;

public interface RestaurentTypeDao {

	public Set<RestaurentType> getRestaurantTypeByID(Set<String> ids);
}
