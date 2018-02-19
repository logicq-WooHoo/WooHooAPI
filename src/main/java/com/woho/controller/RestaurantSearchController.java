package com.woho.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.woho.service.RestaurantSearchService;

@RestController
public class RestaurantSearchController {

	@Autowired
	RestaurantSearchService restaurantSearchService;
	
	@RequestMapping(value = "/user/restaurant/search", method = RequestMethod.POST, consumes = "application/json")
	public void registerUSer(@RequestBody String city, String area, String foodCategory) {
	}
}
