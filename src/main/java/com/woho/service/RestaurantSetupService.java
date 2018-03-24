package com.woho.service;

import java.util.Set;

import com.woho.model.DeliveryPartner;
import com.woho.model.RestaurantSetup;
import com.woho.model.RestaurantType;

public interface RestaurantSetupService {
	
	Set<DeliveryPartner> getDeliveryPartners(Long restaurantId);
	Set<String> getDeliveryPartnerNames(Long restaurantId);
	Set<RestaurantType> getRestaurantTypes(Long restaurantId);
	Set<String> getRestaurantTypeNames(Long restaurantId);
	Set<RestaurantSetup> getByRestaurantTypeId(Long restTypeId);
}
