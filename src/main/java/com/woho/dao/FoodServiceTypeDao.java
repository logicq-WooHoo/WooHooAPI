package com.woho.dao;

import java.util.Set;
import com.woho.model.FoodServiceType;

public interface FoodServiceTypeDao {
	
	Set<FoodServiceType> getFoodServiceTypesByID(Set<String> ids);
	
	FoodServiceType getFoodServiceTypeByID(String id);
	
	void addFoodServiceType(FoodServiceType foodServiceType);
	
	void deleteFoodServiceType(FoodServiceType foodServiceType);
	
	void updateFooderviceTypeCategory(FoodServiceType foodServiceType);

}
