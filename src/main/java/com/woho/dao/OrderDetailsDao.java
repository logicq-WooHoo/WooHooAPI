package com.woho.dao;

import java.util.List;

import com.woho.model.OrderDetails;

/**
 * 
 * @author Pankaj Labade
 *
 */
public interface OrderDetailsDao {
	OrderDetails get(String orderId);

	List<OrderDetails> getByUserId(Long userId);

	void add(OrderDetails orderDetails);
}
