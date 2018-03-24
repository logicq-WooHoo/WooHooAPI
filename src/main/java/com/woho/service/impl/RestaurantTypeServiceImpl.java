package com.woho.service.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.woho.dao.RestaurantTypeDao;
import com.woho.model.RestaurantType;
import com.woho.service.RestaurantTypeService;

@Service
@Transactional
public class RestaurantTypeServiceImpl implements RestaurantTypeService{
	
	@Autowired
	RestaurantTypeDao restaurentTypeDao;
	
	@Override
	@Transactional(readOnly = true)
	public Set<RestaurantType> getRestaurantTypeByID(Set<String> ids) {
		return restaurentTypeDao.getRestaurantTypeByID(ids);
	}

	@Override
	@Transactional(readOnly = true)
	public RestaurantType getById(Long id) {
		return restaurentTypeDao.getById(id);
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

	@Override
	@Transactional(readOnly = true)
	public List<RestaurantType> list() {
		return restaurentTypeDao.list();
	}
}
