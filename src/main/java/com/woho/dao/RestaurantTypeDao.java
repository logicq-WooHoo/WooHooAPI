package com.woho.dao;

import java.util.List;
import java.util.Set;

import com.woho.model.DeliveryPartner;
import com.woho.model.RestaurantType;

public interface RestaurantTypeDao {

	public Set<RestaurantType> getRestaurantTypeByID(Set<String> ids);

	RestaurantType getById(Long id);

	void addRestaurentType(RestaurantType restaurentType);

	void deleteRestaurentType(RestaurantType restaurentType);

	void updateRestaurentType(RestaurantType restaurentTypes);

	List<RestaurantType> list();
}
