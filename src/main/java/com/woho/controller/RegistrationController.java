package com.woho.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.woho.model.RestaurantDetails;
import com.woho.model.UserInformation;
import com.woho.service.RegistrationService;
import com.woho.vo.RestaurantSetupVO;

@RestController
@RequestMapping("/api")
public class RegistrationController {

	@Autowired
	RegistrationService registrationService;

	/**
	 * @param type
	 * @param user
	 */
	@RequestMapping(value = "/user/registration", method = RequestMethod.POST, consumes = "application/json")
	public void registerUSer(@RequestBody UserInformation userInformation) {
		registrationService.register(userInformation);
	}

	/**
	 * 
	 * @param restaurantDetails
	 */
	@RequestMapping(value = "/restaurant/registration/details", method = RequestMethod.POST, consumes = "application/json")
	public void registerRestaurantDetails(@RequestBody RestaurantDetails restaurantDetails) {
		registrationService.registerRestaurantDetails(restaurantDetails);
	}

	@RequestMapping(value = "/restaurant/setup", method = RequestMethod.POST, consumes = "application/json")
	public void registerRestaurantSetup(@RequestBody RestaurantSetupVO restaurantSetupVO) throws JsonProcessingException {
		registrationService.registerRestaurantSetup(restaurantSetupVO);
	}
	
}
