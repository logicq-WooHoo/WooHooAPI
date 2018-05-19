package com.woho.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.woho.dao.HotelDetailsDao;
import com.woho.helper.ObjectFactory;
import com.woho.model.Address;
import com.woho.model.Amenity;
import com.woho.model.HotelDetails;
import com.woho.model.HotelReview;
import com.woho.service.AddressService;
import com.woho.service.HotelReviewService;
import com.woho.service.HotelService;
import com.woho.vo.HotelVO;

/**
 * 
 * @author Pankaj Labade
 *
 */
@Service
@Transactional
public class HotelServiceImpl implements HotelService {
	@Autowired
	AddressService addressService;
	@Autowired
	HotelDetailsDao hotelDetailsDao;
	@Autowired
	HotelReviewService hotelReviewService;

	private ObjectMapper objectMapper = ObjectFactory.getObjectMapper();

	Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	@Override
	public List<HotelVO> searchHotel(HotelVO hotelVO) throws Exception {
		List<HotelDetails> hotelDetailsList = null;
		hotelVO.setType("hotel");
		List<Address> addresses = addressService.searchAddress(hotelVO);
		if (!CollectionUtils.isEmpty(addresses)) {
			hotelDetailsList = hotelDetailsDao.getByAddressList(addresses);
		}
		if (!CollectionUtils.isEmpty(hotelDetailsList) && !StringUtils.isEmpty(hotelVO.getHotelName())) {
			List<HotelDetails> hds = hotelDetailsDao.findByHotelName(hotelVO.getHotelName());
			if (!CollectionUtils.isEmpty(hotelDetailsList) && !CollectionUtils.isEmpty(hds)) {
				hotelDetailsList = hotelDetailsList.stream().filter(
						hotelDetails -> hds.stream().anyMatch(hdsbyname -> hdsbyname.getId() == hotelDetails.getId()))
						.collect(Collectors.toList());
			}
			if (CollectionUtils.isEmpty(hds)) {
				List<HotelDetails> hdsByType = hotelDetailsDao.findByType(hotelVO.getHotelName());	
				if (!CollectionUtils.isEmpty(hotelDetailsList) && !CollectionUtils.isEmpty(hdsByType)) {
					hotelDetailsList = hotelDetailsList.stream().filter(
							hotelDetails -> hdsByType.stream().anyMatch(hdByType -> hdByType.getId() == hotelDetails.getId()))
							.collect(Collectors.toList());
				} else {
					hotelDetailsList.clear();
				}
			}
		}
		return generateRestaurantVOList(hotelDetailsList);
	}

	private List<HotelVO> generateRestaurantVOList(List<HotelDetails> hotelDetailsList) throws Exception {
		List<HotelVO> hotelVOList = new ArrayList<>();
		if (!CollectionUtils.isEmpty(hotelDetailsList)) {
			hotelDetailsList.forEach(hd -> {
				HotelVO hotelVO = new HotelVO();
				hotelVO.setHotelName(hd.getHotelName());
				hotelVO.setType(hd.getType().getName());
				hotelVO.setArea(hd.getAddress().getLocality());
				hotelVO.setCity(hd.getAddress().getCity());
				HotelReview hotelReview = hotelReviewService.getByHotelId(hd.getId());
				if (!ObjectUtils.isEmpty(hotelReview)) {
					if (!ObjectUtils.isEmpty(hotelReview.getRecommendationCount())) {
						hotelVO.setRecommendationCount(hotelReview.getRecommendationCount());
					}
					if (!ObjectUtils.isEmpty(hotelReview.getRating())) {
						hotelVO.setRating(hotelReview.getRating());
					}
				}
				hotelVO.setAmenities(getAmenityNames(hd.getId()));

				try {
					Map<String, Double> outServices = objectMapper.readValue(hd.getOutServices(),
							new TypeReference<Map<String, Double>>() {
							});
					if (!CollectionUtils.isEmpty(outServices)) {
						hotelVO.setOutServices(outServices);
					}
				} catch (IOException e) {
					logger.error(e.getMessage() + e);
				}

				hotelVOList.add(hotelVO);
			});
		}
		return hotelVOList;
	}

	@Override
	public Set<String> getAmenityNames(Long hotelId) {
		Set<Amenity> amenities = getAmenities(hotelId);
		if (!CollectionUtils.isEmpty(amenities)) {
			return amenities.stream().map(a -> a.getName()).collect(Collectors.toSet());
		}
		return null;
	}

	@Override
	public Set<Amenity> getAmenities(Long hotelId) {
		HotelDetails hotelDetails = hotelDetailsDao.get(hotelId);
		return hotelDetails.getAmenities();
	}
}
