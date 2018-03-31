package com.woho.vo;

import java.util.List;
import java.util.Set;

/**
 * 
 * @author Pankaj Labade
 *
 */
public class RestaurantSearchVO extends AddressVO {

	/**
	 * foodCategory : Tandoori, Chinees etc. See food_category table for reference
	 * values.
	 */
	private String foodCategory;
	/**
	 * foodServiceType : Breakfast(Long value 1), Lunch(Long value 2) etc. See
	 * food_service_type table for reference values
	 */
	private Set<String> foodServiceTypes;
	/**
	 * rating : 4 Star (Double value 4). See restaurant_review table for reference
	 * values.
	 */
	private Double rating;
	/**
	 * restaurantTypeId: like 1 for American
	 */
	private Long restaurantTypeId;

	private List<Long> restaurantIds;

	public String getFoodCategory() {
		return foodCategory;
	}

	public void setFoodCategory(String foodCategory) {
		this.foodCategory = foodCategory;
	}

	public Set<String> getFoodServiceTypes() {
		return foodServiceTypes;
	}

	public void setFoodServiceTypes(Set<String> foodServiceTypes) {
		this.foodServiceTypes = foodServiceTypes;
	}

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	public Long getRestaurantTypeId() {
		return restaurantTypeId;
	}

	public void setRestaurantTypeId(Long restaurantTypeId) {
		this.restaurantTypeId = restaurantTypeId;
	}

	public List<Long> getRestaurantIds() {
		return restaurantIds;
	}

	public void setRestaurantIds(List<Long> restaurantIds) {
		this.restaurantIds = restaurantIds;
	}

	@Override
	public String toString() {
		return "RestaurantSearchVO [foodCategory=" + foodCategory + ", foodServiceTypes=" + foodServiceTypes
				+ ", rating=" + rating + ", restaurantTypeId=" + restaurantTypeId + ", restaurantIds=" + restaurantIds
				+ "]";
	}
}
