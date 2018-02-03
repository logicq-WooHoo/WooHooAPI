package com.woho.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woho.dao.RestaurantDetailsDao;
import com.woho.dao.UserInformationrDao;
import com.woho.model.RestaurantDetails;
import com.woho.model.UserInformation;
import com.woho.service.RegistrationService;

@Service
@Transactional
public class RegistrationServiceImpl implements RegistrationService{

	@Autowired
	UserInformationrDao userInformationrDao;
	
	@Autowired
	RestaurantDetailsDao restaurantDetailsDao;
	
	@Override
	public void register(UserInformation userInformation) {
		userInformationrDao.addUser(userInformation);
	}

	@Override
	public void registerRestaurantDetails(RestaurantDetails restaurantDetails) {
		restaurantDetailsDao.addRestaurantDetails(restaurantDetails);
	}
	
}
