package com.woho.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.woho.model.Address;
import com.woho.model.OrderDetails;
import com.woho.model.UserInformation;
import com.woho.vo.CartVO;
import com.woho.vo.OrderDetailsVO;
import com.woho.vo.PaymentCardVO;
import com.woho.vo.UserVO;

public interface UserService {

	UserInformation getUser(UserVO userVO);

	UserInformation getUser(Long id);

	UserVO addUser(UserInformation userInformation) throws Exception;

	void validateUser(UserInformation userInformation) throws Exception;

	List<OrderDetailsVO> getPastOrders(Long userId) throws Exception;

	// Set<OrderDetailsVO> getOrderDetails(String trackingId);

	OrderDetails placeOrder(CartVO cartVO) throws Exception;
	// Set<OrderDetailsVO> reOrder(String trackingId);

	Map<String, Double> getTotalBillWithTax(Double subTotal);

	OrderDetailsVO reOrder(String trackingId);

	void saveCardDetails(PaymentCardVO paymentCardVO);

	UserVO getMyProfile(Long userId);

	UserInformation authenticateUser(String username, String password);

	UserVO getUserByEmailId(String emailId) throws Exception;

	UserVO getMyProfile(String emailId) throws Exception;

	List<OrderDetailsVO> getPastOrders(String emailId) throws Exception;

	Set<Address> addAddress(UserVO userVO) throws Exception;
	
	Set<Address> getUserAddresses(String emailId) throws Exception;

}
