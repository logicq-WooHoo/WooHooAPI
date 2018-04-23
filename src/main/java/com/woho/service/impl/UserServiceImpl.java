package com.woho.service.impl;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.woho.dao.OrderTrackingDao;
import com.woho.dao.PaymentCardDao;
import com.woho.dao.UserInformationDao;
import com.woho.helper.ObjectFactory;
import com.woho.model.OrderTracking;
import com.woho.model.PaymentCard;
import com.woho.model.UserInformation;
import com.woho.service.UserService;
import com.woho.vo.CartVO;
import com.woho.vo.OrderTrackingVO;
import com.woho.vo.PaymentCardVO;
import com.woho.vo.UserVO;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	UserInformationDao userInformationDao;
	@Autowired
	OrderTrackingDao orderTrackingDao;
	@Autowired
	PaymentCardDao paymentCardDao;

	private ObjectMapper objectMapper = ObjectFactory.getObjectMapper();

	private static final Logger logger = Logger.getLogger(UserServiceImpl.class);

	private static final DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

	@Override
	public UserInformation getUser(UserVO userVO) {

		UserInformation userInformation = userInformationDao.findUserByEmail(userVO.getEmailId());

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
			CartVO orderJson = null;
			try {
				orderJson = objectMapper.readValue(new String(orderTracking.getOrderJson()), CartVO.class);

			} catch (IOException e) {
				logger.error(e.getMessage(), e);
			}
			orderTrackingVO.setOrderJson(orderJson);
			orderTrackingVOList.add(orderTrackingVO);
		});
		return orderTrackingVOList;
	}

	/*
	 * @Override public Set<OrderDetailsVO> getOrderDetails(String trackingId) {
	 * Set<OrderDetailsVO> orderDetailsVOSet = new HashSet<OrderDetailsVO>();
	 * OrderTracking orderTracking = orderTrackingDao.get(trackingId); if
	 * (!ObjectUtils.isEmpty(orderTracking)) { Set<OrderDetails> orderDetailsList =
	 * orderTracking.getOrderDetails(); orderDetailsList.forEach(orderDetails -> {
	 * OrderDetailsVO orderDetailsVO = new OrderDetailsVO();
	 * orderDetailsVO.setId(orderDetails.getId()); Map<String, Object> orderJson =
	 * null; try { orderJson = objectMapper.readValue(orderDetails.getOrderJson(),
	 * new TypeReference<Map<String, Object>>() { }); } catch (IOException e) {
	 * logger.error(e.getMessage(), e); } orderDetailsVO.setOrderJson(orderJson);
	 * orderDetailsVO.setRestaurantId(orderDetails.getRestaurantDetails().getId());
	 * orderDetailsVO.setDeliveryAddresses(orderDetails.getDeliveryAddresses());
	 * orderDetailsVOSet.add(orderDetailsVO); }); } return orderDetailsVOSet; }
	 */

	@Override
	public Map<String, Double> getTotalBillWithTax(Double subTotal) {
		Map<String, Double> paymentDetails = new HashMap<>();
		double gst = subTotal * 0.09;
		paymentDetails.put("Sub Total", subTotal);
		paymentDetails.put("SGST", gst);
		paymentDetails.put("CGST", gst);
		paymentDetails.put("Grand Total", subTotal + (gst * 2));
		return paymentDetails;
	}

	@Override
	public void placeOrder(CartVO cartVO) throws Exception {
		OrderTracking orderTracking = new OrderTracking();
		orderTracking.setId(RandomStringUtils.randomAlphanumeric(6));
		orderTracking.setOrderJson(objectMapper.writeValueAsBytes(cartVO));
		orderTracking.setTimestamp(new Date());
		if (!ObjectUtils.isEmpty(cartVO.getUserId())) {
			orderTracking.setUserInformation(userInformationDao.get(cartVO.getUserId()));
		}
		orderTrackingDao.add(orderTracking);

	}

	@Override
	public void reOrder(String trackingId) {
		OrderTracking orderTracking = new OrderTracking();
		OrderTracking dbOrderTracking = orderTrackingDao.get(trackingId);
		orderTracking.setId(RandomStringUtils.randomAlphanumeric(6));
		orderTracking.setTimestamp(new Date());
		orderTracking.setUserInformation(dbOrderTracking.getUserInformation());
		orderTracking.setOrderJson(dbOrderTracking.getOrderJson());
		orderTrackingDao.add(orderTracking);
	}

	@Override
	public void saveCardDetails(PaymentCardVO paymentCardVO) {
		PaymentCard paymentCard = new PaymentCard();
		if (!ObjectUtils.isEmpty(paymentCardVO)) {
			paymentCard.setCardNumber(paymentCardVO.getCardNumber());
			paymentCard.setCardType(paymentCardVO.getCardType());
			paymentCard.setCvv(paymentCardVO.getCvv());
			paymentCard.setExpireOn(paymentCardVO.getExpireOn());
			paymentCard.setUserInformation(userInformationDao.get(paymentCardVO.getUserId()));
			paymentCardDao.addPaymentCard(paymentCard);
		}
	}

	@Override
	public UserInformation getUser(Long id) {
		return userInformationDao.get(id);
	}

	@Override
	public UserVO getMyProfile(Long userId) {
		UserVO userVO = new UserVO();
		userVO.setUserInformation(userInformationDao.get(userId));
		List<PaymentCardVO> paymentCardVOs = new ArrayList<>();
		List<PaymentCard> paymentCards = paymentCardDao.getByUserId(userId);
		paymentCards.forEach(paymentCard -> {
			PaymentCardVO paymentCardVO = new PaymentCardVO();
			paymentCardVO.setCardNumber(paymentCard.getCardNumber());
			paymentCardVO.setCardType(paymentCard.getCardType());
			paymentCardVO.setCvv(paymentCard.getCvv());
			paymentCardVO.setExpireOn(paymentCard.getExpireOn());
			paymentCardVOs.add(paymentCardVO);
		});
		userVO.setPaymentCards(paymentCardVOs);
		return userVO;
	}

}
