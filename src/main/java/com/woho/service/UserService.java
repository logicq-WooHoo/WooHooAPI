package com.woho.service;

import java.util.List;
import java.util.Map;

import com.woho.model.UserInformation;
import com.woho.vo.CartVO;
import com.woho.vo.OrderTrackingVO;
import com.woho.vo.UserVO;

public interface UserService {

	UserInformation getUser(UserVO userVO);

	List<OrderTrackingVO> getpastorders(Long userId);

	//Set<OrderDetailsVO> getOrderDetails(String trackingId);

	void placeOrder(CartVO cartVO) throws Exception;
	// Set<OrderDetailsVO> reOrder(String trackingId);

	Map<String, Double> getTotalBillWithTax(Double subTotal);

	void reOrder(String trackingId);

	
}
