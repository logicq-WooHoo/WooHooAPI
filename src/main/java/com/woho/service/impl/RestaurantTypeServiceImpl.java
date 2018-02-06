package com.woho.service.impl;

import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woho.dao.RestaurantTypeDao;
import com.woho.model.RestaurantType;
import com.woho.service.RestaurantTypeService;

@Service
@Transactional
public class RestaurantTypeServiceImpl implements RestaurantTypeService{
	
	@Autowired
	RestaurantTypeDao restaurentTypeDao;
	
	@Override
	public Set<RestaurantType> getRestaurantTypeByID(Set<String> ids) {
		return restaurentTypeDao.getRestaurantTypeByID(ids);
	}

	@Override
	public void addRestaurentType(RestaurantType restaurentType) {
		restaurentTypeDao.addRestaurentType(restaurentType);
	}

	@Override
	public void deleteRestaurentType(RestaurantType restaurentType) {
		restaurentTypeDao.deleteRestaurentType(restaurentType);
	}

	@Override
	public void updateRestaurentType(RestaurantType restaurentType) {
		restaurentTypeDao.updateRestaurentType(restaurentType);
	}
}
