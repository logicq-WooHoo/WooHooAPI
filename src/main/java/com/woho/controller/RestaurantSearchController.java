package com.woho.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.woho.model.FoodCategory;
import com.woho.model.RestaurantMenu;
import com.woho.service.FoodCategoryService;
import com.woho.service.RestaurantMenuService;
import com.woho.service.RestaurantSearchService;
import com.woho.vo.RestaurantSearchVO;
import com.woho.vo.RestaurantVO;

@RestController
@RequestMapping("/api")
public class RestaurantSearchController {

	@Autowired
	RestaurantSearchService restaurantSearchService;
	@Autowired
	RestaurantMenuService restaurantMenuService;
	@Autowired
	FoodCategoryService foodCategoryService;
	
	@RequestMapping(value = "/user/restaurant/search", method = RequestMethod.POST, consumes = "application/json")
	public List<RestaurantVO> searchRestaurant(@RequestBody RestaurantSearchVO restaurantSearchVO) throws Exception {
		return restaurantSearchService.searchRestaurant(restaurantSearchVO);
	}
	
	@RequestMapping(value = "/user/restaurant/selectmenu", method = RequestMethod.POST, consumes = "application/json")
	public RestaurantMenu selectMenu(@RequestBody Long restaurantId) throws Exception {
		return restaurantMenuService.getByRestaurantId(restaurantId);
	}
	
	@RequestMapping(value = "/getFoodCategories", method = RequestMethod.GET, consumes = "application/json")
	public List<FoodCategory> getFoodCategories() throws JsonProcessingException {
		return foodCategoryService.getFoodCategories();
	}
}