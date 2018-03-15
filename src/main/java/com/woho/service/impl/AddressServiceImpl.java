package com.woho.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woho.dao.AddressDao;
import com.woho.model.Address;
import com.woho.service.AddressService;
import com.woho.vo.AddressVO;

@Service
@Transactional
public class AddressServiceImpl implements AddressService {

	@Autowired
	AddressDao addressDao;
	
	@Override
	public List<Address> searchAddress(AddressVO addressVO) throws Exception {
		return addressDao.searchAddress(addressVO);
	}
	
}