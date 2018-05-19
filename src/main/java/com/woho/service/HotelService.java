package com.woho.service;

import java.util.List;
import java.util.Set;

import com.woho.model.Amenity;
import com.woho.vo.HotelVO;

public interface HotelService {

	List<HotelVO> searchHotel(HotelVO hotelVO) throws Exception;

	Set<String> getAmenityNames(Long hotelId);

	Set<Amenity> getAmenities(Long hotelId);

}
