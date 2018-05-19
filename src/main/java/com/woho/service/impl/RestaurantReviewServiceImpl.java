package com.woho.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.woho.dao.RestaurantReviewDao;
import com.woho.model.RestaurantDetails;
import com.woho.model.RestaurantReview;
import com.woho.service.RestaurantReviewService;

@Service
@Transactional
public class RestaurantReviewServiceImpl implements RestaurantReviewService {

	@Autowired
	RestaurantReviewDao restaurantReviewDao;

	@Override
	public RestaurantReview getByRestaurantId(Long restaurantId) {
		return restaurantReviewDao.getByRestaurantId(restaurantId);
	}

	@Override
	public List<RestaurantReview> get(Double rating, List<RestaurantDetails> restaurants) {
		return restaurantReviewDao.get(rating, restaurants);
	}

}
