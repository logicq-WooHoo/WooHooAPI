package com.woho.service;

import java.util.List;
import java.util.Set;

import com.woho.model.UserInformation;
import com.woho.vo.OrderDetailsVO;
import com.woho.vo.OrderTrackingVO;
import com.woho.vo.UserVO;

public interface UserService {

	UserInformation getUser(UserVO userVO);

	List<OrderTrackingVO> getpastorders(Long userId);

	Set<OrderDetailsVO> getOrderDetails(String trackingId);
}
