package com.woho.service;

import java.util.List;

import com.woho.model.Address;
import com.woho.vo.AddressVO;

public interface AddressService {

	List<Address> searchAddress(AddressVO addressVO) throws Exception;

	Address add(Address address);

	Address get(Long id);

	List<Address> list();

	void delete(Long id);

	void update(Long id, Address address);

	public boolean isAddressExist(Long id);
}
