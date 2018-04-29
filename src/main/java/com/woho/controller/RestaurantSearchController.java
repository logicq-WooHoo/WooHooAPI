package com.woho.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.woho.model.DeliveryPartner;
import com.woho.model.FoodCategory;
import com.woho.model.FoodServiceType;
import com.woho.model.MenuItem;
import com.woho.model.RestaurantType;
import com.woho.model.TravelerPick;
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
		Map<String, List<Long>> restTypeCountMap = new HashMap<>();
		List<RestaurantVO> restaurantVOs = restaurantSearchService.searchRestaurant(restaurantSearchVO);
		if (!CollectionUtils.isEmpty(restaurantVOs)) {
			restaurantVOs.forEach(rest -> {
				Set<String> restTypes = rest.getRestaurantTypes();
				if (!CollectionUtils.isEmpty(restTypes)) {
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
				}
			});
		}
		/**
		 * sort by keys, a,b,c..., and return a new LinkedHashMap toMap() will returns
		 * HashMap by default, we need LinkedHashMap to keep the order.
		 */
		Map<String, List<Long>> sortedRestTypeCountMap = restTypeCountMap.entrySet().stream()
				.sorted(Map.Entry.comparingByKey()).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
						(oldValue, newValue) -> oldValue, LinkedHashMap::new));

		return sortedRestTypeCountMap;
	}

	@RequestMapping(value = "/user/restaurant/search", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public List<RestaurantVO> searchRestaurant(@RequestBody RestaurantSearchVO restaurantSearchVO) throws Exception {
		return restaurantSearchService.searchRestaurant(restaurantSearchVO);
	}

	@RequestMapping(value = "/user/restaurant/selectmenu/{restaurantId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Set<MenuItem> selectMenu(@PathVariable("restaurantId") Long restaurantId) throws Exception {
		return restaurantMenuService.getMenuItemsByRestaurantId(restaurantId);
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

	/**
	 * 
	 * @param travelerPick
	 * @return top food/things according to entity type like food/activity etc
	 * @throws Exception
	 */
	@RequestMapping(value = "/getravelerpick", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<RestaurantMenuVO> geTravelerPick(@RequestBody TravelerPick travelerPick) throws Exception {
		return restaurantSearchService.getTravelerPick(travelerPick);
	}
}