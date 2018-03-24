package com.woho.dao;

import java.util.List;
import java.util.Set;

import com.woho.model.FoodServiceType;

public interface FoodServiceTypeDao {

	Set<FoodServiceType> getFoodServiceTypesByID(Set<String> ids);

	FoodServiceType getFoodServiceTypeByID(Long id);

	void addFoodServiceType(FoodServiceType foodServiceType);

	void deleteFoodServiceType(FoodServiceType foodServiceType);

	void updateFooderviceTypeCategory(FoodServiceType foodServiceType);

	List<FoodServiceType> list();
}
