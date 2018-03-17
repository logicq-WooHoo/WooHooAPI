package com.woho.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.woho.dao.RestaurantDetailsDao;
import com.woho.model.Address;
import com.woho.model.FoodCategory;
import com.woho.model.RestaurantDetails;
import com.woho.model.RestaurantDetailsFoodCategory;
import com.woho.service.AddressService;
import com.woho.service.FoodCategoryService;
import com.woho.service.MenuItemService;
import com.woho.service.RestaurantDetailsFoodCategoryService;
import com.woho.service.RestaurantMenuService;
import com.woho.service.RestaurantSearchService;
import com.woho.vo.RestaurantSearchVO;
import com.woho.vo.RestaurantVO;

@Service
@Transactional
public class RestaurantSearchServiceImpl implements RestaurantSearchService{

	@Autowired
	AddressService addressService;
	@Autowired
	RestaurantDetailsDao restaurantDetailsService;
	@Autowired
	MenuItemService menuItemService;
	@Autowired
	RestaurantMenuService restaurantMenuService;
	@Autowired
	FoodCategoryService foodCategoryService;
	@Autowired
	RestaurantDetailsFoodCategoryService restaurantDetailsFoodCategoryService;
	
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
		
		List<RestaurantDetails> restaurantDetailsList = restaurantDetailsService.getByAddressList(addresses);
		
		if (!StringUtils.isEmpty(restaurantSearchVO.getFoodCategory())) {
			FoodCategory foodCategory = foodCategoryService.getFoodCategory(restaurantSearchVO.getFoodCategory());
			List<RestaurantDetailsFoodCategory> restaurantDetailsFoodCategoryList = restaurantDetailsFoodCategoryService.getByFoodCategoryID(foodCategory.getCategoryId());
			restaurantDetailsList = restaurantDetailsList.stream().filter(
					rd -> restaurantDetailsFoodCategoryList.stream().anyMatch(rdFd -> rdFd.getRestId() == rd.getId()))
					.collect(Collectors.toList());
		}
		
		RestaurantVO restaurantVO = new RestaurantVO();
		
		/*List<Long> restIds = restaurantDetailsFoodCategoryList.stream().map(RestaurantDetailsFoodCategory::getRestId)
				.collect(Collectors.toList());*/
		
		
		/*clicks.stream()
	    .filter(click -> campaigns.stream()
	        .filter(camp -> "prospecting".equals(camp.type))
	        .anyMatch(camp -> 
	            camp.campaignId == click.campaignId &&
	            camp.end.after(click.date) &&
	            camp.start.before(click.date)
	        )
	    )
	    .collect(Collectors.toList());*/
		
		
		//restaurantDetailsList.stream().map(RestaurantDetails::getId).filter(restIds::contains).collect(Collectors.toList());
		//restaurantDetailsList.stream().filter(restIds::contains).collect(Collectors.toList());
		
		
		
		return restaurantDetailsList;
	}

}
