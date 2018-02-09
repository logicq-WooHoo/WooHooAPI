package com.woho.dao.impl;

import java.util.Set;
import org.springframework.stereotype.Repository;
import com.woho.dao.AbstractDAO;
import com.woho.dao.FoodCategoryDao;
import com.woho.model.FoodCategory;

@Repository
public class FoodCategoryDaoImpl extends AbstractDAO<FoodCategory> implements FoodCategoryDao{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public Set<FoodCategory> getFoodCategoriesByID(Set<String> ids) {
		return null;
	}

	@Override
	public FoodCategory getFoodCategoryByID(String id) {
		return (FoodCategory)getRecordById(FoodCategory.class, id);
	}

	@Override
	public void addFoodCategory(FoodCategory foodCategory) {
		save(foodCategory);
	}

	@Override
	public void deleteFoodCategory(FoodCategory foodCategory) {
		delete(foodCategory);
	}

	@Override
	public void updateFoodCategory(FoodCategory foodCategory) {
		update(foodCategory);
	}

}
