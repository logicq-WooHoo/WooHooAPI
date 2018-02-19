package com.woho.service;

public interface RestaurantSearchService {
	
	public void getRestaurantCities();
	
	public void getAreasByCity(String city);
	
	public void getRestaurantsByCityAndArea(String cityt,String area);
	
	public void getRestaurantsByCityAndAreaAndFoodCategory(String cityt,String area,Long foodCategoryId);

}
