package com.woho.vo;

/**
 * 
 * @author Pankaj Labade
 *
 */
public class RestaurantSearchVO extends AddressVO {
	
	private String foodCategory;

	public String getFoodCategory() {
		return foodCategory;
	}

	public void setFoodCategory(String foodCategory) {
		this.foodCategory = foodCategory;
	}

	@Override
	public String toString() {
		return "RestaurantSearchVO [foodCategory=" + foodCategory + "]";
	}
	
}
