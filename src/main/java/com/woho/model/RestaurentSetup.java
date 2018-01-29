package com.woho.model;

import java.util.List;

import javax.persistence.Entity;

@Entity
public class RestaurentSetup {
	
	private List<RestaurentType> restTypes;
	
	private List<DeliveryPartner> deliveryPartners;

}
