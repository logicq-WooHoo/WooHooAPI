package com.woho.dao.impl;

import org.springframework.stereotype.Repository;

import com.woho.dao.AbstractDAO;
import com.woho.dao.RestaurantSetupDao;
import com.woho.model.RestaurantSetup;

@Repository
public class RestaurantSetupDaoImpl extends AbstractDAO<RestaurantSetup> implements RestaurantSetupDao {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5323065306211922795L;

	@Override
	public void addRestaurantSetup(RestaurantSetup restaurantSetup) {
		save(restaurantSetup);
	}

	@Override
	public RestaurantSetup getByRestaurantId(Long restaurantId) {
		String sqlquery = "from RestaurantSetup where restaurantDetails.id='" + restaurantId + "'"; 
		return executeQueryForUniqueRecord(sqlquery);
	}

}
