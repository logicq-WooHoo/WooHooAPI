package com.woho.dao.impl;

import java.util.Set;

import org.springframework.stereotype.Repository;

import com.woho.dao.AbstractDAO;
import com.woho.dao.FoodServiceTypeDao;
import com.woho.model.FoodServiceType;

@Repository
public class FoodServiceTypeDaoImpl extends AbstractDAO<FoodServiceType> implements FoodServiceTypeDao {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4122343012739266163L;

	@Override
	public Set<FoodServiceType> getFoodServiceTypesByID(Set<String> ids) {
		return null;
	}

	@Override
	public FoodServiceType getFoodServiceTypeByID(Long id) {
		return (FoodServiceType)getRecordById(FoodServiceType.class, id);
	}

	@Override
	public void addFoodServiceType(FoodServiceType foodServiceType) {
		save(foodServiceType);
	}

	@Override
	public void deleteFoodServiceType(FoodServiceType foodServiceType) {
		delete(foodServiceType);
	}

	@Override
	public void updateFooderviceTypeCategory(FoodServiceType foodServiceType) {
		update(foodServiceType);
	}

}
