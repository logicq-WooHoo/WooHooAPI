package com.woho.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.woho.dao.FoodServiceTypeDao;
import com.woho.model.FoodServiceType;
import com.woho.service.FoodServiceTypeService;

@Service
@Transactional
public class FoodServiceTypeServiceImpl implements FoodServiceTypeService {

	@Autowired
	FoodServiceTypeDao foodServiceTypeDao;

	@Override
	public Set<FoodServiceType> getFoodServiceTypesByID(Set<String> types) {
		return null;
	}

	@Override
	public FoodServiceType getFoodServiceTypeByID(Long id) {
		return foodServiceTypeDao.getFoodServiceTypeByID(id);
	}

	@Override
	public void addFoodServiceType(FoodServiceType foodServiceType) {
		foodServiceTypeDao.addFoodServiceType(foodServiceType);
	}

	@Override
	public void deleteFoodServiceType(FoodServiceType foodServiceType) {
		foodServiceTypeDao.deleteFoodServiceType(foodServiceType);
	}

	@Override
	public void updateFoodServiceType(FoodServiceType foodServiceType) {
		foodServiceTypeDao.updateFooderviceTypeCategory(foodServiceType);
	}

}
