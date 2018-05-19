package com.woho.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.woho.dao.AbstractDAO;
import com.woho.dao.HotelReviewDao;
import com.woho.model.HotelDetails;
import com.woho.model.HotelReview;

/**
 * 
 * @author Pankaj Labade
 *
 */
@Repository
public class HotelReviewDaoImpl extends AbstractDAO<HotelReview> implements HotelReviewDao {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6278953172710806326L;

	@Override
	public HotelReview getByHotelId(Long hotelId) {
		String query = "from HotelReview where hotelDetails.id=" + hotelId; 
		return executeQueryForUniqueRecord(query);
	}

	@Override
	public List<HotelReview> get(Double rating, List<HotelDetails> hotelDetailsList) {
		String hql = "from HotelReview where rating>='" + rating + "' and hotelDetails in (:list)"; 
		return (List<HotelReview>) executeQueryWithList(hql, hotelDetailsList);
	}

}
