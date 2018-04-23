package com.woho.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.woho.dao.AbstractDAO;
import com.woho.dao.PaymentCardDao;
import com.woho.model.PaymentCard;

/**
 * 
 * @author Pankaj Labade
 *
 */
@Repository
public class PaymentCardDaoImpl extends AbstractDAO<PaymentCard> implements PaymentCardDao {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3891750325512341006L;

	@Override
	public void addPaymentCard(PaymentCard PaymentCard) {
		save(PaymentCard);
	}

	@Override
	public PaymentCard get(Long id) {
		return getRecordById(PaymentCard.class, id);
	}

	@Override
	public List<PaymentCard> getByUserId(Long userId) {
		String hql = "from PaymentCard where userInformation.userId=" + userId;
		return executeQuery(hql);
	}

}
