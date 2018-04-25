package com.woho.service;

import java.util.List;

import com.woho.model.Address;
import com.woho.vo.AddressVO;

public interface AddressService {

	List<Address> searchAddress(AddressVO addressVO) throws Exception;

	Address get(Long id);
}
