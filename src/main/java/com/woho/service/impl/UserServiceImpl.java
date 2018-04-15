package com.woho.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.woho.dao.OrderDetailsDao;
import com.woho.dao.OrderTrackingDao;
import com.woho.dao.UserInformationrDao;
import com.woho.helper.ObjectFactory;
import com.woho.model.OrderDetails;
import com.woho.model.OrderTracking;
import com.woho.model.UserInformation;
import com.woho.service.UserService;
import com.woho.vo.OrderDetailsVO;
import com.woho.vo.OrderTrackingVO;
import com.woho.vo.UserVO;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	UserInformationrDao userInformationrDao;
	@Autowired
	OrderTrackingDao orderTrackingDao;
	@Autowired
	OrderDetailsDao orderDetailsDao;

	private ObjectMapper objectMapper = ObjectFactory.getObjectMapper();
	
	private static final Logger logger = Logger.getLogger(UserServiceImpl.class);

	@Override
	public UserInformation getUser(UserVO userVO) {

		UserInformation userInformation = userInformationrDao.findUserByEmail(userVO.getEmailId());

		return userInformation;

	}

	@Override
	public List<OrderTrackingVO> getpastorders(Long userId) {
		List<OrderTracking> orderTrackingList = orderTrackingDao.getByUserId(userId);
		List<OrderTrackingVO> orderTrackingVOList = new ArrayList<OrderTrackingVO>();
		orderTrackingList.forEach(orderTracking -> {
			OrderTrackingVO orderTrackingVO = new OrderTrackingVO();
			orderTrackingVO.setTrackingId(orderTracking.getId());
			orderTrackingVO.setTimestamp(orderTracking.getTimestamp());
			orderTrackingVOList.add(orderTrackingVO);
		});
		return orderTrackingVOList;
	}

	@Override
	public Set<OrderDetailsVO> getOrderDetails(String trackingId) {
		Set<OrderDetailsVO> orderDetailsVOSet = new HashSet<OrderDetailsVO>();
		OrderTracking orderTracking = orderTrackingDao.get(trackingId);
		if (!ObjectUtils.isEmpty(orderTracking)) {
			Set<OrderDetails> orderDetailsList =  orderTracking.getOrderDetails();
			orderDetailsList.forEach(orderDetails -> {
				OrderDetailsVO orderDetailsVO = new OrderDetailsVO();
				orderDetailsVO.setId(orderDetails.getId());
				Map<String, Object> orderJson = null;
				try {
					orderJson = objectMapper.readValue(orderDetails.getOrderJson(),
							new TypeReference<Map<String, Object>>() {
							});
				} catch (IOException e) {
					logger.error(e.getMessage(), e);
				}
				orderDetailsVO.setOrderJson(orderJson);
				orderDetailsVO.setRestaurantId(orderDetails.getRestaurantDetails().getId());
				orderDetailsVO.setDeliveryAddresses(orderDetails.getDeliveryAddresses());
				orderDetailsVOSet.add(orderDetailsVO);
			});
		}
		return orderDetailsVOSet;
	}

}
