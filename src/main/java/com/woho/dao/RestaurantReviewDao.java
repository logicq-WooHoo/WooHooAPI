package com.woho.dao;

import java.util.List;

import com.woho.model.RestaurantDetails;
import com.woho.model.RestaurantReview;

/**
 * 
 * @author Pankaj Labade
 *
 */
public interface RestaurantReviewDao {

	RestaurantReview getByRestaurantId(Long restaurantId);
	List<RestaurantReview> get(Double rating, List<RestaurantDetails> restaurants);
}
