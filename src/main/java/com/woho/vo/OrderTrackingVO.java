package com.woho.vo;

/**
 * 
 * @author Pankaj Labade
 *
 */
public class OrderTrackingVO {
	private String OrderTrackingId;
	private RestaurantMenuVO orderDetails;

	public String getOrderTrackingId() {
		return OrderTrackingId;
	}

	public void setOrderTrackingId(String orderTrackingId) {
		OrderTrackingId = orderTrackingId;
	}

	public RestaurantMenuVO getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(RestaurantMenuVO orderDetails) {
		this.orderDetails = orderDetails;
	}

}
