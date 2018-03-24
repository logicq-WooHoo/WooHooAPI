package com.woho.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.woho.dao.RestaurantDetailsDao;
import com.woho.model.Address;
import com.woho.model.FoodCategory;
import com.woho.model.MenuItem;
import com.woho.model.RestaurantDetails;
import com.woho.model.RestaurantDetailsFoodCategory;
import com.woho.model.RestaurantMenu;
import com.woho.model.RestaurantReview;
import com.woho.model.RestaurantSetup;
import com.woho.service.AddressService;
import com.woho.service.FoodCategoryService;
import com.woho.service.MenuItemService;
import com.woho.service.RestaurantDetailsFoodCategoryService;
import com.woho.service.RestaurantMenuService;
import com.woho.service.RestaurantReviewService;
import com.woho.service.RestaurantSearchService;
import com.woho.service.RestaurantSetupService;
import com.woho.vo.RestaurantSearchVO;
import com.woho.vo.RestaurantVO;

@Service
@Transactional
public class RestaurantSearchServiceImpl implements RestaurantSearchService {

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
	@Autowired
	RestaurantSetupService restaurantSetupService;
	@Autowired
	RestaurantReviewService restaurantReviewService;

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
	@Transactional(readOnly = true)
	public List<RestaurantVO> searchRestaurant(RestaurantSearchVO restaurantSearchVO) throws Exception {
		restaurantSearchVO.setType("restaurant");
		List<Address> addresses = addressService.searchAddress(restaurantSearchVO);
		List<RestaurantDetails> restaurantDetailsList = restaurantDetailsService.getByAddressList(addresses);
		if (!StringUtils.isEmpty(restaurantSearchVO.getFoodCategory())) {
			FoodCategory foodCategory = foodCategoryService.getFoodCategory(restaurantSearchVO.getFoodCategory());
			List<RestaurantDetailsFoodCategory> restaurantDetailsFoodCategoryList = restaurantDetailsFoodCategoryService
					.getByFoodCategoryID(foodCategory.getCategoryId());
			restaurantDetailsList = restaurantDetailsList.stream().filter(
					rd -> restaurantDetailsFoodCategoryList.stream().anyMatch(rdFd -> rdFd.getRestId() == rd.getId()))
					.collect(Collectors.toList());
		}
		if (null != restaurantSearchVO.getFoodServiceTypes() && !restaurantSearchVO.getFoodServiceTypes().isEmpty()) {
			List<MenuItem> menuItems = menuItemService
					.getByFoodServiceTypes(new ArrayList(restaurantSearchVO.getFoodServiceTypes()));

			List<RestaurantMenu> restaurantMenus = restaurantMenuService.getByMenuItemsAndRestaurantDetails(
					new HashSet<MenuItem>(menuItems), new HashSet<RestaurantDetails>(restaurantDetailsList));

			restaurantDetailsList = restaurantMenus.stream().map(rm -> rm.getRestaurantDetails())
					.collect(Collectors.toList());
		}

		if (null != restaurantSearchVO.getRating()) {
			List<RestaurantReview> restaurantReviews = restaurantReviewService.get(restaurantSearchVO.getRating(),
					restaurantDetailsList);
			restaurantDetailsList = restaurantReviews.stream().map(rr -> rr.getRestaurantDetails())
					.collect(Collectors.toList());
		}

		if(null != restaurantSearchVO.getRestaurantTypeId()) {
			Set<RestaurantSetup> restaurantSetups = restaurantSetupService.getByRestaurantTypeId(restaurantSearchVO.getRestaurantTypeId());
			restaurantDetailsList = restaurantDetailsList.stream().filter(
					rd -> restaurantSetups.stream().anyMatch(rs -> rs.getRestaurantDetails().getId() == rd.getId()))
					.collect(Collectors.toList());
		}
		
		List<RestaurantVO> restaurantVOList = new ArrayList<>();
		restaurantDetailsList.forEach(rd -> {
			RestaurantVO restaurantVO = new RestaurantVO();
			restaurantVO.setArea(rd.getAddress().getLocality());
			restaurantVO.setCity(rd.getAddress().getCity());
			restaurantVO.setDeliveryPartners(restaurantSetupService.getDeliveryPartnerNames(rd.getId()));
			restaurantVO.setId(rd.getId());
			restaurantVO.setRecommendationCount(
					restaurantReviewService.getByRestaurantId(rd.getId()).getRecommendationCount());
			restaurantVO.setRating(restaurantReviewService.getByRestaurantId(rd.getId()).getRating());
			restaurantVO.setRestaurantName(rd.getRestaurantName());
			restaurantVO.setRestaurantTypes(restaurantSetupService.getRestaurantTypeNames(rd.getId()));
			restaurantVOList.add(restaurantVO);
		});
		return restaurantVOList;
	}

}
