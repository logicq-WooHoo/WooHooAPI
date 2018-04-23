package com.woho.dao;

import java.util.List;

import com.woho.model.PaymentCard;

/**
 * 
 * @author Pankaj Labade
 *
 */
public interface PaymentCardDao {

	void addPaymentCard(PaymentCard PaymentCard);

	PaymentCard get(Long id);

	List<PaymentCard> getByUserId(Long userId);

}
