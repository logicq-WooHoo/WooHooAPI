package com.woho.dao.impl;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.woho.dao.AbstractDAO;
import com.woho.dao.FoodCategoryDao;
import com.woho.model.FoodCategory;

@Repository
public class FoodCategoryDaoImpl extends AbstractDAO<FoodCategory> implements FoodCategoryDao {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3536116924386973407L;

	@Override
	public Set<FoodCategory> getFoodCategoriesByID(Set<String> ids) {
		return null;
	}

	@Override
	public FoodCategory getFoodCategoryByID(Long id) {
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

	@Override
	public List<FoodCategory> list() {
		return (List<FoodCategory>) loadClass(FoodCategory.class);
	}

	@Override
	public FoodCategory getFoodCategory(String category) {
		String query = "from FoodCategory where category='" + category + "'";
		return executeQueryForUniqueRecord(query);
	}
	
}
