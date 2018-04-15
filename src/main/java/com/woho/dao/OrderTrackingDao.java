package com.woho.dao;

import java.util.List;

import com.woho.model.OrderTracking;

/**
 * 
 * @author Pankaj Labade
 *
 */
public interface OrderTrackingDao {
	OrderTracking get(String trackingId);
	List<OrderTracking> getByUserId(Long userId);
}
