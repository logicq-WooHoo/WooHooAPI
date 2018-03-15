package com.woho.service;

import java.util.List;

import com.woho.model.RestaurantDetails;
import com.woho.vo.RestaurantSearchVO;

public interface RestaurantSearchService {
	
	public void getRestaurantCities();
	
	public void getAreasByCity(String city);
	
	public void getRestaurantsByCityAndArea(String cityt,String area);
	
	public void getRestaurantsByCityAndAreaAndFoodCategory(String cityt,String area,Long foodCategoryId);
	
	List<RestaurantDetails> searchRestaurant(RestaurantSearchVO restaurantSearchVO) throws Exception;

}
