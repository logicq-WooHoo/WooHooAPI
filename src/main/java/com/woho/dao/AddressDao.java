package com.woho.dao;

import java.util.List;

import com.woho.model.Address;

public interface AddressDao {

	List<Address> searchAddress(String city, String area, String type) throws Exception;

	List<Address> searchAddress(Double latitude, Double longitude, String type) throws Exception;

	Address add(Address address);

	Address get(Long id);

	List<Address> list();

	void delete(Long id);

	void update(Long id, Address address);

	public boolean isAddressExist(Long id);
}
