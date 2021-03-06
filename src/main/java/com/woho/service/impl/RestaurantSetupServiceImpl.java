package com.woho.service.impl;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.woho.dao.RestaurantSetupDao;
import com.woho.model.DeliveryPartner;
import com.woho.model.RestaurantSetup;
import com.woho.model.RestaurantType;
import com.woho.service.RestaurantSetupService;
import com.woho.service.RestaurantTypeService;

@Service
@Transactional
public class RestaurantSetupServiceImpl implements RestaurantSetupService {

	@Autowired
	RestaurantSetupDao restaurantSetupDao;
	@Autowired
	RestaurantTypeService restaurantTypeService;

	@Override
	public Set<DeliveryPartner> getDeliveryPartners(Long restaurantId) {
		RestaurantSetup restaurantSetup = restaurantSetupDao.getByRestaurantId(restaurantId);
		return restaurantSetup.getDeliveryPartners();
	}

	@Override
	public Set<String> getDeliveryPartnerNames(Long restaurantId) {
		Set<DeliveryPartner> deliveryPartners = getDeliveryPartners(restaurantId);
		if (!CollectionUtils.isEmpty(deliveryPartners)) {
			return deliveryPartners.stream().map(dp -> dp.getName()).collect(Collectors.toSet());
		}
		return null;
	}

	@Override
	public Set<RestaurantType> getRestaurantTypes(Long restaurantId) {
		RestaurantSetup restaurantSetup = restaurantSetupDao.getByRestaurantId(restaurantId);
		return restaurantSetup.getRestTypes();
	}

	@Override
	public Set<String> getRestaurantTypeNames(Long restaurantId) {
		Set<RestaurantType> restaurantTypes = getRestaurantTypes(restaurantId);
		if (!CollectionUtils.isEmpty(restaurantTypes)) {
			return restaurantTypes.stream().map(rt -> rt.getType()).collect(Collectors.toSet());
		}
		return null;
	}

	@Override
	public Set<RestaurantSetup> getByRestaurantTypeId(Long restTypeId) {
		return restaurantTypeService.getById(restTypeId).getRestaurantSetup();
	}

}
