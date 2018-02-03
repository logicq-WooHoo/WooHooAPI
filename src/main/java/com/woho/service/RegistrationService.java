package com.woho.service;

import com.woho.model.RestaurantDetails;
import com.woho.model.UserInformation;

public interface RegistrationService {
	
	void register(UserInformation user);
	void registerRestaurantDetails(RestaurantDetails restaurantDetails);
}
