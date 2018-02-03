package com.woho.model;

import java.util.List;

import javax.persistence.Entity;

public class RestaurantSetup {
	
	private List<RestaurentType> restTypes;
	
	private List<DeliveryPartner> deliveryPartners;

	public List<RestaurentType> getRestTypes() {
		return restTypes;
	}

	public void setRestTypes(List<RestaurentType> restTypes) {
		this.restTypes = restTypes;
	}

	public List<DeliveryPartner> getDeliveryPartners() {
		return deliveryPartners;
	}

	public void setDeliveryPartners(List<DeliveryPartner> deliveryPartners) {
		this.deliveryPartners = deliveryPartners;
	}

	
}
