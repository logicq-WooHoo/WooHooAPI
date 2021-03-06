package com.woho.service;

import java.util.List;
import java.util.Set;

import com.woho.model.FoodServiceType;

public interface FoodServiceTypeService {

	Set<FoodServiceType> getFoodServiceTypesByID(Set<String> ids);

	FoodServiceType getFoodServiceTypeByID(Long id);

	void addFoodServiceType(FoodServiceType foodServiceType);

	void deleteFoodServiceType(FoodServiceType foodServiceType);

	void updateFoodServiceType(FoodServiceType foodServiceType);

	List<FoodServiceType> list();

}
