package com.woho.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.woho.dao.AbstractDAO;
import com.woho.dao.OrderTrackingDao;
import com.woho.model.OrderTracking;

/**
 * 
 * @author Pankaj Labade
 *
 */
@Repository
public class OrderTrackingDaoImpl extends AbstractDAO<OrderTracking> implements OrderTrackingDao {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6721702347889583942L;

	@Override
	public List<OrderTracking> getByUserId(Long userId) {
		String hql = "from OrderTracking where userInformation.userId='" + userId + "'";
		return executeQuery(hql);
	}

	@Override
	public OrderTracking get(String id) {
		return getRecordById(OrderTracking.class, id);
	}

}
