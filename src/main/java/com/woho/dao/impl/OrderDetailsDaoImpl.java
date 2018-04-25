package com.woho.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.woho.dao.AbstractDAO;
import com.woho.dao.OrderDetailsDao;
import com.woho.model.OrderDetails;

/**
 * 
 * @author Pankaj Labade
 *
 */
@Repository
public class OrderDetailsDaoImpl extends AbstractDAO<OrderDetails> implements OrderDetailsDao {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2072033995462765962L;

	@Override
	public OrderDetails get(String orderId) {
		return getRecordById(OrderDetails.class, orderId);
	}

	@Override
	public List<OrderDetails> getByUserId(Long userId) {
		String hql = "from OrderDetails where userInformation.userId='" + userId + "'";
		return executeQuery(hql);
	}

	@Override
	public void add(OrderDetails orderDetails) {
		save(orderDetails);
	}

}
