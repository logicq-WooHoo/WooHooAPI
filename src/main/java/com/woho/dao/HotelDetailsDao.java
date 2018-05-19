package com.woho.dao;

import java.util.List;

import com.woho.model.Address;
import com.woho.model.HotelDetails;

/**
 * 
 * @author Pankaj Labade
 *
 */
public interface HotelDetailsDao {

	HotelDetails addHotelDetails(HotelDetails hotelDetails);

	HotelDetails get(Long id);

	HotelDetails getByRegistrationNumber(String registrationNumber);
	
	List<HotelDetails> list();

	void delete(Long id);

	void update(Long id, HotelDetails hotelDetails);

	public boolean isHotelDetailsExist(HotelDetails hotelDetails);

	List<HotelDetails> getByAddressList(List<Address> addresses);

	List<HotelDetails> getByIdList(List<Long> ids);

	List<HotelDetails> findByHotelName(String hotelName);
	
	List<HotelDetails> findByType(String type);
}
