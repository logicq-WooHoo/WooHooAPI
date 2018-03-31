package com.woho.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.woho.model.DeliveryPartner;
import com.woho.model.FoodCategory;
import com.woho.model.FoodServiceType;
import com.woho.model.RestaurantMenu;
import com.woho.model.RestaurantType;
import com.woho.service.DeliveryPartnerService;
import com.woho.service.FoodCategoryService;
import com.woho.service.FoodServiceTypeService;
import com.woho.service.RestaurantMenuService;
import com.woho.service.RestaurantSearchService;
import com.woho.service.RestaurantTypeService;
import com.woho.vo.RestaurantMenuVO;
import com.woho.vo.RestaurantSearchVO;
import com.woho.vo.RestaurantVO;

@RestController
@RequestMapping("/api")
public class RestaurantSearchController {

	@Autowired
	RestaurantSearchService restaurantSearchService;
	@Autowired
	RestaurantMenuService restaurantMenuService;
	@Autowired
	FoodCategoryService foodCategoryService;
	@Autowired
	DeliveryPartnerService deliveryPartnerService;
	@Autowired
	FoodServiceTypeService foodServiceTypeService;
	@Autowired
	RestaurantTypeService restaurantTypeService;

	@RequestMapping(value = "/user/restaurant/searchtype", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, List<Long>> searchRestaurantTypes(@RequestBody RestaurantSearchVO restaurantSearchVO)
			throws Exception {
		List<RestaurantVO> restaurantVOs = restaurantSearchService.searchRestaurant(restaurantSearchVO);
		Map<String, List<Long>> restTypeCountMap = new HashMap<>();
		restaurantVOs.forEach(rest -> {
			Set<String> restTypes = rest.getRestaurantTypes();
			restTypes.forEach(rt -> {
				if (restTypeCountMap.containsKey(rt)) {
					List<Long> restIds = restTypeCountMap.get(rt);
					restIds.add(rest.getId());
					restTypeCountMap.put(rt, restIds);
				} else {
					List<Long> restIds = new ArrayList<>();
					restIds.add(rest.getId());
					restTypeCountMap.put(rt, restIds);
				}
			});
		});
		return restTypeCountMap;
	}

	@RequestMapping(value = "/user/restaurant/search", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public List<RestaurantVO> searchRestaurant(@RequestBody RestaurantSearchVO restaurantSearchVO) throws Exception {
		return restaurantSearchService.searchRestaurant(restaurantSearchVO);
	}

	@RequestMapping(value = "/user/restaurant/selectmenu", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public RestaurantMenu selectMenu(@RequestBody RestaurantMenuVO restaurantMenuVO) throws Exception {
		return restaurantMenuService.getByRestaurantId(restaurantMenuVO.getRestaurantId());
	}

	@RequestMapping(value = "/getfoodcategories", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<FoodCategory> getFoodCategories() throws JsonProcessingException {
		return foodCategoryService.list();
	}

	@RequestMapping(value = "/getdeliverypartners", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<DeliveryPartner> getDeliveryPartners() throws Exception {
		return deliveryPartnerService.list();
	}

	@RequestMapping(value = "/getfoodservicetypes", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<FoodServiceType> getFoodServiceTypes() throws Exception {
		return foodServiceTypeService.list();
	}

	@RequestMapping(value = "/getrestauranttypes", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<RestaurantType> getRestaurantTypes() throws Exception {
		return restaurantTypeService.list();
	}
}