package com.woho.vo;

import java.util.List;
import java.util.Set;

public class RestaurantSetupVO {

	private Set<String> restaurentTypes;

	private Set<String> deliveryPartners;

	private List<TimeDetailVO>  operationTime;

	private List<TimeDetailVO>  deliveryServices;

	public Set<String> getRestaurentTypes() {
		return restaurentTypes;
	}

	public void setRestaurentTypes(Set<String> restaurentTypes) {
		this.restaurentTypes = restaurentTypes;
	}

	public Set<String> getDeliveryPartners() {
		return deliveryPartners;
	}

	public void setDeliveryPartners(Set<String> deliveryPartners) {
		this.deliveryPartners = deliveryPartners;
	}

	public List<TimeDetailVO> getOperationTime() {
		return operationTime;
	}

	public void setOperationTime(List<TimeDetailVO> operationTime) {
		this.operationTime = operationTime;
	}

	public List<TimeDetailVO> getDeliveryServices() {
		return deliveryServices;
	}

	public void setDeliveryServices(List<TimeDetailVO> deliveryServices) {
		this.deliveryServices = deliveryServices;
	}

}