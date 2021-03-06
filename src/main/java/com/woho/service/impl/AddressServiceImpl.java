package com.woho.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

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
	@Transactional(readOnly = true)
	public List<Address> searchAddress(AddressVO addressVO) throws Exception {
		List<Address> addresses = null;
		if (null != addressVO) {
			if (!StringUtils.isEmpty(addressVO.getCity()) || !StringUtils.isEmpty(addressVO.getArea())) {
				addresses = addressDao.searchAddress(addressVO.getCity(), addressVO.getArea(), addressVO.getType());
			}

			if (!StringUtils.isEmpty(addressVO.getLatitude()) && !StringUtils.isEmpty(addressVO.getLongitude())) {
				addresses = addressDao.searchAddress(addressVO.getLatitude(), addressVO.getLongitude(),
						addressVO.getType());
			}
		}
		return addresses;
	}

	@Override
	@Transactional(readOnly = true)
	public Address get(Long id) {
		return addressDao.get(id);
	}

	@Override
	public Address add(Address address) {
		return addressDao.add(address);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Address> list() {
		return addressDao.list();
	}

	@Override
	public void delete(Long id) {
		addressDao.delete(id);
	}

	@Override
	public void update(Long id, Address address) {
		addressDao.update(id, address);
	}

	@Override
	public boolean isAddressExist(Long id) {
		return addressDao.isAddressExist(id);
	}
}