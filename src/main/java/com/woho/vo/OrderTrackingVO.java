package com.woho.vo;

import java.util.Date;

/**
 * 
 * @author Pankaj Labade
 *
 */
public class OrderTrackingVO {

	private String trackingId;

	private Date timestamp;

	private CartVO orderJson;

	public String getTrackingId() {
		return trackingId;
	}

	public void setTrackingId(String trackingId) {
		this.trackingId = trackingId;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public CartVO getOrderJson() {
		return orderJson;
	}

	public void setOrderJson(CartVO orderJson) {
		this.orderJson = orderJson;
	}

	@Override
	public String toString() {
		return "OrderTrackingVO [trackingId=" + trackingId + ", timestamp=" + timestamp + ", orderJson=" + orderJson
				+ "]";
	}
}
