package com.woho.dao.impl;

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
	private static final long serialVersionUID = -8449386911748751606L;

	@Override
	public OrderDetails get(Long id) {
		return getRecordById(OrderDetails.class, id);
	}
}
