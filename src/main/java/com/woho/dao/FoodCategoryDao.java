package com.woho.dao;

import java.util.List;
import java.util.Set;

import com.woho.model.FoodCategory;

public interface FoodCategoryDao {
	
	Set<FoodCategory> getFoodCategoriesByID(Set<String> ids);
	
	FoodCategory getFoodCategoryByID(Long id);
	
	FoodCategory getFoodCategory(String category);
	
	void addFoodCategory(FoodCategory foodCategory);
	
	void deleteFoodCategory(FoodCategory foodCategory);
	
	void updateFoodCategory(FoodCategory foodCategory);

	List<FoodCategory> list();
}
