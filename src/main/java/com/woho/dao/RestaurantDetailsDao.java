package com.woho.dao;

import java.util.List;

import com.woho.model.Address;
import com.woho.model.RestaurantDetails;

/**
 * 
 * @author Pankaj Labade
 *
 */
public interface RestaurantDetailsDao {

	void addRestaurantDetails(RestaurantDetails restaurantDetails);
	RestaurantDetails get(long id);
	RestaurantDetails getByRegistrationNumber(String registrationNumber);
	List<RestaurantDetails> list();
	void delete(long id);
	void update(long id, RestaurantDetails restaurantDetails);
	public boolean isRestaurantDetailsExist(RestaurantDetails restaurantDetails);
	
	List<RestaurantDetails> getByAddressList(List<Address> addresses);
}
