package com.woho.dao;

import java.util.List;

import com.woho.model.HotelDetails;
import com.woho.model.HotelReview;

/**
 * 
 * @author Pankaj Labade
 *
 */
public interface HotelReviewDao {

	HotelReview getByHotelId(Long hotelId);

	List<HotelReview> get(Double rating, List<HotelDetails> hotelDetailsList);
}
