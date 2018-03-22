package com.woho.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.woho.dao.AbstractDAO;
import com.woho.dao.RestaurantReviewDao;
import com.woho.model.RestaurantDetails;
import com.woho.model.RestaurantReview;

@Repository
public class RestaurantReviewDaoImpl extends AbstractDAO<RestaurantReview> implements RestaurantReviewDao {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4906416206825512099L;

	@Override
	public RestaurantReview getByRestaurantId(Long restaurantId) {
		String sqlquery = "from RestaurantReview where restaurantDetails.id='" + restaurantId + "'"; 
		return executeQueryForUniqueRecord(sqlquery);
	}

	@Override
	public List<RestaurantReview> get(Double rating, List<RestaurantDetails> restaurants) {
		String hql = "from RestaurantReview where rating>='" + rating + "' and restaurantDetails in (:list)"; 
		return (List<RestaurantReview>) executeQueryWithList(hql, restaurants);
	}

}
