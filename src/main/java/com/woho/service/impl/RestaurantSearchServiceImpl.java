package com.woho.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woho.dao.RestaurantDetailsDao;
import com.woho.model.Address;
import com.woho.model.RestaurantDetails;
import com.woho.service.AddressService;
import com.woho.service.RestaurantSearchService;
import com.woho.vo.RestaurantSearchVO;

@Service
@Transactional
public class RestaurantSearchServiceImpl implements RestaurantSearchService{

	@Autowired
	AddressService addressService;
	@Autowired
	RestaurantDetailsDao restaurantDetailsDao;
	
	@Override
	public void getRestaurantCities() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getAreasByCity(String city) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getRestaurantsByCityAndArea(String cityt, String area) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getRestaurantsByCityAndAreaAndFoodCategory(String cityt, String area, Long foodCategoryId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<RestaurantDetails> searchRestaurant(RestaurantSearchVO restaurantSearchVO) throws Exception {
		restaurantSearchVO.setType("restaurant");
		List<Address> addresses = addressService.searchAddress(restaurantSearchVO);
		return restaurantDetailsDao.getByAddressList(addresses);
	}

}
