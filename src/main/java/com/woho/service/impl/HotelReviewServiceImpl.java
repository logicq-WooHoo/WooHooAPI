package com.woho.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.woho.dao.HotelReviewDao;
import com.woho.model.HotelDetails;
import com.woho.model.HotelReview;
import com.woho.service.HotelReviewService;

/**
 * 
 * @author Pankaj Labade
 *
 */
@Service
@Transactional
public class HotelReviewServiceImpl implements HotelReviewService {

	@Autowired
	HotelReviewDao hotelReviewDao;

	@Override
	public HotelReview getByHotelId(Long hotelId) {
		return hotelReviewDao.getByHotelId(hotelId);
	}

	@Override
	public List<HotelReview> get(Double rating, List<HotelDetails> hotelDetailsList) {
		// TODO Auto-generated method stub
		return null;
	}

	


}
