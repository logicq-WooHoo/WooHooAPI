package com.woho.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.woho.model.RestaurantDetails;
import com.woho.model.UserInformation;
import com.woho.vo.RestaurantMenuVO;
import com.woho.vo.RestaurantSetupVO;

public interface RegistrationService {
	
	void register(UserInformation user);
	void registerRestaurantDetails(RestaurantDetails restaurantDetails);
	void registerRestaurantSetup(RestaurantSetupVO restaurantSetup) throws JsonProcessingException;
	void registerRestaurantMenu(RestaurantMenuVO restaurantMenuVO) throws JsonProcessingException;
}
