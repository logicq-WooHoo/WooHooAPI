package com.woho.service.impl;

import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.woho.dao.FoodCategoryDao;
import com.woho.model.FoodCategory;
import com.woho.service.FoodCategoryService;

@Service
public class FoodCategoryServiceImpl implements FoodCategoryService{
	
	@Autowired
	FoodCategoryDao foodCategoryDao;
	
	@Override
	public Set<FoodCategory> getFoodCategoriesByID(Set<String> types) {
		return null;
	}
	
	@Override
	public FoodCategory getFoodCategoryByID(Long id) {
		return foodCategoryDao.getFoodCategoryByID(id);
	}

	@Override
	public void addFoodCategory(FoodCategory foodCategory) {
		foodCategoryDao.addFoodCategory(foodCategory);
	}

	@Override
	public void deleteFoodCategory(FoodCategory foodCategory) {
		foodCategoryDao.deleteFoodCategory(foodCategory);
	}

	@Override
	public void updateFoodCategory(FoodCategory foodCategory) {
		foodCategoryDao.updateFoodCategory(foodCategory);
	}

	@Override
	public void getFoodCategories() {
		// TODO Auto-generated method stub
		
	}
}
