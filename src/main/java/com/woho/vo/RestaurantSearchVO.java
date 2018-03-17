package com.woho.vo;

/**
 * 
 * @author Pankaj Labade
 *
 */
public class RestaurantSearchVO extends AddressVO {
	
	private String foodCategory;
	private String foodServiceType;
	private Double rating;
	
	public String getFoodCategory() {
		return foodCategory;
	}

	public void setFoodCategory(String foodCategory) {
		this.foodCategory = foodCategory;
	}

	public String getFoodServiceType() {
		return foodServiceType;
	}

	public void setFoodServiceType(String foodServiceType) {
		this.foodServiceType = foodServiceType;
	}

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "RestaurantSearchVO [foodCategory=" + foodCategory + ", foodServiceType=" + foodServiceType + ", rating="
				+ rating + "]";
	}

}
