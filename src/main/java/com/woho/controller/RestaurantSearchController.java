package com.woho.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.woho.model.FoodCategory;
import com.woho.service.FoodCategoryService;
import com.woho.service.RestaurantSearchService;

@RestController
public class RestaurantSearchController {

	@Autowired
	RestaurantSearchService restaurantSearchService;
	
	@Autowired
	FoodCategoryService foodCategoryService;
	
	@RequestMapping(value = "/user/restaurant/search", method = RequestMethod.POST, consumes = "application/json")
	public void registerUSer(@RequestBody String city, String area, String foodCategory) {
	}
	
	@RequestMapping(value = "/getFoodCategories", method = RequestMethod.GET, consumes = "application/json")
	public List<FoodCategory> getFoodCategories() throws JsonProcessingException {
		return null;
	}
}
