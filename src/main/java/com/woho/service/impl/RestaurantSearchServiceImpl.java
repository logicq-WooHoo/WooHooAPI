package com.woho.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
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
import com.woho.model.TravelerPick;
import com.woho.service.AddressService;
import com.woho.service.FoodCategoryService;
import com.woho.service.MenuItemService;
import com.woho.service.RestaurantDetailsFoodCategoryService;
import com.woho.service.RestaurantMenuService;
import com.woho.service.RestaurantReviewService;
import com.woho.service.RestaurantSearchService;
import com.woho.service.RestaurantSetupService;
import com.woho.service.TravelerPickService;
import com.woho.vo.RestaurantMenuVO;
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
	@Autowired
	TravelerPickService travelerPickService;

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
		List<MenuItem> menuItems = new ArrayList<>();
		restaurantSearchVO.setType("restaurant");
		List<RestaurantDetails> restaurantDetailsList = null;
		if (!CollectionUtils.isEmpty(restaurantSearchVO.getRestaurantIds())) {
			restaurantDetailsList = restaurantDetailsService.getByIdList(restaurantSearchVO.getRestaurantIds());
		}
		List<Address> addresses = addressService.searchAddress(restaurantSearchVO);
		if (!CollectionUtils.isEmpty(addresses)) {
			restaurantDetailsList = restaurantDetailsService.getByAddressList(addresses);
		}
		if (!StringUtils.isEmpty(restaurantSearchVO.getFoodCategory())) {
			/**
			 * Here foodCategory key can contain values for foodCategory/menu/restaurantname
			 */
			FoodCategory foodCategory = foodCategoryService.getFoodCategory(restaurantSearchVO.getFoodCategory());
			if (!ObjectUtils.isEmpty(foodCategory)) {
				List<RestaurantDetailsFoodCategory> restaurantDetailsFoodCategoryList = restaurantDetailsFoodCategoryService
						.getByFoodCategoryID(foodCategory.getCategoryId());
				if (!CollectionUtils.isEmpty(restaurantDetailsFoodCategoryList)) {
					restaurantDetailsList = restaurantDetailsList.stream()
							.filter(rd -> restaurantDetailsFoodCategoryList.stream()
									.anyMatch(rdFd -> rdFd.getRestId() == rd.getId()))
							.collect(Collectors.toList());
				}
			}

			List<RestaurantDetails> rds = restaurantDetailsService
					.findByRestaurantName(restaurantSearchVO.getFoodCategory());
			if (!CollectionUtils.isEmpty(restaurantDetailsList) && !CollectionUtils.isEmpty(rds)) {
				restaurantDetailsList = restaurantDetailsList.stream()
						.filter(rd -> rds.stream().anyMatch(rdsbyname -> rdsbyname.getId() == rd.getId()))
						.collect(Collectors.toList());
			}

			menuItems.addAll(menuItemService.findByMenuItem(restaurantSearchVO.getFoodCategory()));
		}

		if (!CollectionUtils.isEmpty(restaurantSearchVO.getFoodServiceTypes())) {
			menuItems.addAll(
					menuItemService.getByFoodServiceTypes(new ArrayList(restaurantSearchVO.getFoodServiceTypes())));

		}

		if (!menuItems.isEmpty()) {
			List<RestaurantMenu> restaurantMenus = restaurantMenuService
					.getByMenuItems(new HashSet<MenuItem>(menuItems));
			restaurantDetailsList = restaurantDetailsList.stream().filter(
					rd -> restaurantMenus.stream().anyMatch(rm -> rm.getRestaurantDetails().getId() == rd.getId()))
					.collect(Collectors.toList());
		}

		if (!ObjectUtils.isEmpty(restaurantSearchVO.getRating())) {
			List<RestaurantReview> restaurantReviews = restaurantReviewService.get(restaurantSearchVO.getRating(),
					restaurantDetailsList);
			restaurantDetailsList = restaurantReviews.stream().map(rr -> rr.getRestaurantDetails())
					.collect(Collectors.toList());
		}

		if (!ObjectUtils.isEmpty(restaurantSearchVO.getRestaurantTypeId())) {
			Set<RestaurantSetup> restaurantSetups = restaurantSetupService
					.getByRestaurantTypeId(restaurantSearchVO.getRestaurantTypeId());
			if (!CollectionUtils.isEmpty(restaurantSetups)) {
				restaurantDetailsList = restaurantDetailsList.stream().filter(
						rd -> restaurantSetups.stream().anyMatch(rs -> rs.getRestaurantDetails().getId() == rd.getId()))
						.collect(Collectors.toList());
			}
		}

		if (!ObjectUtils.isEmpty(restaurantSearchVO.getRestaurantName())) {
			List<RestaurantDetails> rds = restaurantDetailsService
					.findByRestaurantName(restaurantSearchVO.getRestaurantName());
			restaurantDetailsList = restaurantDetailsList.stream()
					.filter(rd -> rds.stream().anyMatch(rdsbyname -> rdsbyname.getId() == rd.getId()))
					.collect(Collectors.toList());
		}
		return generateRestaurantVOList(restaurantDetailsList);
	}

	private List<RestaurantVO> generateRestaurantVOList(List<RestaurantDetails> restaurantDetailsList) {
		List<RestaurantVO> restaurantVOList = new ArrayList<>();
		if (!CollectionUtils.isEmpty(restaurantDetailsList)) {
			restaurantDetailsList.forEach(rd -> {
				RestaurantVO restaurantVO = new RestaurantVO();
				restaurantVO.setArea(rd.getAddress().getLocality());
				restaurantVO.setCity(rd.getAddress().getCity());
				restaurantVO.setDeliveryPartners(restaurantSetupService.getDeliveryPartnerNames(rd.getId()));
				restaurantVO.setId(rd.getId());
				RestaurantReview restaurantReview = restaurantReviewService.getByRestaurantId(rd.getId());
				if (!ObjectUtils.isEmpty(restaurantReview)) {
					if (!ObjectUtils.isEmpty(restaurantReview.getRecommendationCount())) {
						restaurantVO.setRecommendationCount(restaurantReview.getRecommendationCount());
					}
					if (!ObjectUtils.isEmpty(restaurantReview.getRating())) {
						restaurantVO.setRating(restaurantReview.getRating());
					}
				}
				restaurantVO.setRestaurantName(rd.getRestaurantName());
				restaurantVO.setRestaurantTypes(restaurantSetupService.getRestaurantTypeNames(rd.getId()));

				if (!ObjectUtils.isEmpty(rd.getPhone())) {
					restaurantVO.setPhone(rd.getPhone());
				}
				if (!ObjectUtils.isEmpty(rd.getWebsite())) {
					restaurantVO.setWebsite(rd.getWebsite());
				}
				if (!ObjectUtils.isEmpty(rd.getDocument())) {
					if (!ObjectUtils.isEmpty(rd.getDocument().getId())) {
						restaurantVO.setDocumentId(rd.getDocument().getId());
					}
					if (!ObjectUtils.isEmpty(rd.getDocument().getFilename())) {
						restaurantVO.setDocumentName(rd.getDocument().getFilename());
					}
					if (!ObjectUtils.isEmpty(rd.getDocument().getFilePath())) {
						restaurantVO.setDocumentFilePath(rd.getDocument().getFilePath());
					}
				}

				restaurantVOList.add(restaurantVO);
			});
		}
		return restaurantVOList;
	}

	@Override
	public List<RestaurantMenuVO> getTravelerPick(TravelerPick travelerPick) throws Exception {
		List<RestaurantMenuVO> restaurantMenuVOs = new ArrayList<>();
		List<TravelerPick> travelerPicks = travelerPickService.getByEntityAndCity(travelerPick);
		travelerPicks.forEach(tp -> {
			RestaurantMenuVO restaurantMenuVO = new RestaurantMenuVO();
			restaurantMenuVO.setRestaurantId(tp.getRestaurantId());
			restaurantMenuVO.setRestaurantName(restaurantDetailsService.get(tp.getRestaurantId()).getRestaurantName());
			restaurantMenuVO.setMenuItem(menuItemService.get(tp.getMenuId()));
			restaurantMenuVOs.add(restaurantMenuVO);
		});
		return restaurantMenuVOs;
	}

}
