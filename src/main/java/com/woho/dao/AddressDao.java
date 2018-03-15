package com.woho.dao;

import java.util.List;

import com.woho.model.Address;
import com.woho.vo.AddressVO;

public interface AddressDao {

	List<Address> searchAddress(AddressVO addressVO) throws Exception;
}
