package com.woho.dao;

import java.util.List;

import com.woho.model.Address;

public interface AddressDao {

	List<Address> searchAddress(String city, String area, String type) throws Exception;

	List<Address> searchAddress(Double latitude, Double longitude) throws Exception;
}
