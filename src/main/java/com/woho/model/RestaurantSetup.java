package com.woho.model;

import java.util.List;

import javax.persistence.Entity;

@Entity
public class RestaurantSetup {
	
	private List<RestaurentType> restTypes;
	
	private List<DeliveryPartner> deliveryPartners;

}
