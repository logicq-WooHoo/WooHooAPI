package com.woho.dao.impl;

import org.springframework.stereotype.Repository;

import com.woho.dao.AbstractDAO;
import com.woho.dao.RestaurantDetailsDao;
import com.woho.model.RestaurantDetails;

/**
 * 
 * @author Pankaj Labade
 *
 */
@Repository
public class RestaurantDetailsDaoImpl extends AbstractDAO<RestaurantDetails> implements RestaurantDetailsDao {

	/**
	 * 
	 */
	private static final long serialVersionUID = -805502462742036340L;

	@Override
	public void addRestaurantDetails(RestaurantDetails restaurantDetails) {
		save(restaurantDetails);
	}

}
