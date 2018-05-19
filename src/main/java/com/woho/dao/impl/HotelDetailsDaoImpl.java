package com.woho.dao.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.woho.dao.AbstractDAO;
import com.woho.dao.HotelDetailsDao;
import com.woho.model.Address;
import com.woho.model.HotelDetails;

/**
 * 
 * @author Pankaj Labade
 *
 */
@Repository
public class HotelDetailsDaoImpl extends AbstractDAO<HotelDetails> implements HotelDetailsDao {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4280560908947721703L;

	Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	@Override
	public HotelDetails addHotelDetails(HotelDetails hotelDetails) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HotelDetails get(Long id) {
		return getRecordById(HotelDetails.class, id);
	}

	@Override
	public HotelDetails getByRegistrationNumber(String registrationNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<HotelDetails> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Long id, HotelDetails hotelDetails) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isHotelDetailsExist(HotelDetails hotelDetails) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<HotelDetails> getByAddressList(List<Address> addresses) {
		List<HotelDetails> hotelDetailsList = null;
		String hql = "from HotelDetails where address in (:list)";
		try {
			hotelDetailsList = (List<HotelDetails>) executeQueryWithList(hql, addresses);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return hotelDetailsList;
	}

	@Override
	public List<HotelDetails> getByIdList(List<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<HotelDetails> findByHotelName(String hotelName) {
		// TODO Auto-generated method stub
		return null;
	}

}
