package com.woho.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.woho.dao.AbstractDAO;
import com.woho.dao.RestaurantDetailsDao;
import com.woho.model.Address;
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

	@Override
	public RestaurantDetails get(long id) {
		return getRecordById(RestaurantDetails.class, id);
	}

	@Override
	public RestaurantDetails getByRegistrationNumber(String registrationNumber) {
		String sqlquery = "from RestaurantDetails where registrationNumber='" + registrationNumber + "'"; 
		return executeQueryForUniqueRecord(sqlquery);
	}
	
	@Override
	public List<RestaurantDetails> list() {
		return (List<RestaurantDetails>) loadClass(RestaurantDetails.class);
	}

	@Override
	public void delete(long id) {
		delete(getRecordById(RestaurantDetails.class, id));
	}

	@Override
	public void update(long id, RestaurantDetails restaurantDetails) {
		restaurantDetails.setId(id);
		update(restaurantDetails);
	}

	@Override
	public boolean isRestaurantDetailsExist(RestaurantDetails restaurantDetails) {
		return getByRegistrationNumber(restaurantDetails.getRegistrationNumber())!=null;
	}

	@Override
	public List<RestaurantDetails> getByAddressList(List<Address> addresses) {
		String hql = "from RestaurantDetails where address in (:list)";
		return (List<RestaurantDetails>) executeQueryWithList(hql, addresses);
	}

	
}
