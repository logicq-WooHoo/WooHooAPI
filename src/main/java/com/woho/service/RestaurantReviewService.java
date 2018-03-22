package com.woho.service;

import java.util.List;

import com.woho.model.RestaurantDetails;
import com.woho.model.RestaurantReview;

public interface RestaurantReviewService {
	
	RestaurantReview getByRestaurantId(Long restaurantId);
	List<RestaurantReview> get(Double rating, List<RestaurantDetails> restaurants);
}
