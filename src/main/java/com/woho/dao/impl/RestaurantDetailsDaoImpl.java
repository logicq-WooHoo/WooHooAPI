package com.woho.dao.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

	
	Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	
	@Override
	public RestaurantDetails addRestaurantDetails(RestaurantDetails restaurantDetails) {
		save(restaurantDetails);
		return restaurantDetails;
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

	@SuppressWarnings("unchecked")
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
		return getByRegistrationNumber(restaurantDetails.getRegistrationNumber()) != null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RestaurantDetails> getByAddressList(List<Address> addresses) {
		List<RestaurantDetails> restaurantDetailsList = null;
		String hql = "from RestaurantDetails where address in (:list)";
		try {
			restaurantDetailsList = (List<RestaurantDetails>) executeQueryWithList(hql, addresses);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return restaurantDetailsList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RestaurantDetails> getByIdList(List<Long> ids) {
		String hql = "from RestaurantDetails where id in (:list)";
		return (List<RestaurantDetails>) executeQueryWithList(hql, ids);
	}

}
