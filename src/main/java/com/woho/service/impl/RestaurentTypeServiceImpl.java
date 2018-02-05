package com.woho.service.impl;

import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woho.dao.RestaurentTypeDao;
import com.woho.model.RestaurentType;
import com.woho.service.RestaurentTypeService;

@Service
@Transactional
public class RestaurentTypeServiceImpl implements RestaurentTypeService{
	
	@Autowired
	RestaurentTypeDao restaurentTypeDao;
	
	@Override
	public Set<RestaurentType> getRestaurantTypeByID(Set<String> ids) {
		return restaurentTypeDao.getRestaurantTypeByID(ids);
	}
}
