package com.woho.service.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.woho.dao.FoodCategoryDao;
import com.woho.model.FoodCategory;
import com.woho.service.FoodCategoryService;

@Service
@Transactional
public class FoodCategoryServiceImpl implements FoodCategoryService {

	@Autowired
	FoodCategoryDao foodCategoryDao;

	@Override
	@Transactional(readOnly = true)
	public Set<FoodCategory> getFoodCategoriesByID(Set<String> types) {
		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public FoodCategory getFoodCategoryByID(Long id) {
		return foodCategoryDao.getFoodCategoryByID(id);
	}

	@Override
	@Transactional(readOnly = true)
	public FoodCategory getFoodCategory(String category) {
		return foodCategoryDao.getFoodCategory(category);
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
	@Transactional(readOnly = true)
	public List<FoodCategory> list() {
		return foodCategoryDao.list();
	}

}
