package com.woho.service;

import java.util.List;
import java.util.Map;

import com.woho.model.OrderDetails;
import com.woho.model.UserInformation;
import com.woho.vo.CartVO;
import com.woho.vo.OrderDetailsVO;
import com.woho.vo.OrderTrackingVO;
import com.woho.vo.PaymentCardVO;
import com.woho.vo.UserVO;

public interface UserService {

	UserInformation getUser(UserVO userVO);

	UserInformation getUser(Long id);

	List<OrderDetailsVO> getpastorders(Long userId) throws Exception;

	// Set<OrderDetailsVO> getOrderDetails(String trackingId);

	OrderDetails placeOrder(CartVO cartVO) throws Exception;
	// Set<OrderDetailsVO> reOrder(String trackingId);

	Map<String, Double> getTotalBillWithTax(Double subTotal);

	OrderDetailsVO reOrder(String trackingId);

	void saveCardDetails(PaymentCardVO paymentCardVO);
	
	UserVO getMyProfile (Long userId);

}
