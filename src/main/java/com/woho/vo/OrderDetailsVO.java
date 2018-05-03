package com.woho.vo;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.woho.model.Address;

/**
 * 
 * @author Pankaj Labade
 *
 */
@JsonInclude(Include.NON_NULL)
public class OrderDetailsVO {

	private String orderId;

	private Date timestamp;

	private Address deliveryAddresses;

	private Long userId;

	private List<OrderTrackingVO> orderTrackings;

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public Address getDeliveryAddresses() {
		return deliveryAddresses;
	}

	public void setDeliveryAddresses(Address deliveryAddresses) {
		this.deliveryAddresses = deliveryAddresses;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public List<OrderTrackingVO> getOrderTrackings() {
		return orderTrackings;
	}

	public void setOrderTrackings(List<OrderTrackingVO> orderTrackings) {
		this.orderTrackings = orderTrackings;
	}

}
