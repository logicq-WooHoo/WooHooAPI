package com.woho.service.impl;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.woho.dao.OrderDetailsDao;
import com.woho.dao.OrderTrackingDao;
import com.woho.dao.PaymentCardDao;
import com.woho.dao.UserInformationDao;
import com.woho.helper.ObjectFactory;
import com.woho.model.MenuItem;
import com.woho.model.OrderDetails;
import com.woho.model.OrderTracking;
import com.woho.model.PaymentCard;
import com.woho.model.UserInformation;
import com.woho.service.AddressService;
import com.woho.service.MenuItemService;
import com.woho.service.RegistrationService;
import com.woho.service.UserService;
import com.woho.vo.CartVO;
import com.woho.vo.MenuItemVO;
import com.woho.vo.OrderDetailsVO;
import com.woho.vo.OrderTrackingVO;
import com.woho.vo.PaymentCardVO;
import com.woho.vo.RestaurantMenuVO;
import com.woho.vo.UserVO;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	UserInformationDao userInformationDao;
	@Autowired
	OrderTrackingDao orderTrackingDao;
	@Autowired
	OrderDetailsDao orderDetailsDao;
	@Autowired
	PaymentCardDao paymentCardDao;
	@Autowired
	AddressService addressService;
	@Autowired
	RegistrationService registrationService;
	@Autowired
	MenuItemService menuItemService;

	private ObjectMapper objectMapper = ObjectFactory.getObjectMapper();

	private static final Logger logger = Logger.getLogger(UserServiceImpl.class);

	private static final DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

	@Override
	public UserInformation getUser(UserVO userVO) {

		UserInformation userInformation = userInformationDao.findUserByEmail(userVO.getEmailId());

		return userInformation;

	}

	@Override
	public List<OrderDetailsVO> getpastorders(Long userId) throws Exception {

		List<OrderDetailsVO> orderDetailsVOList = new ArrayList<OrderDetailsVO>();

		List<OrderDetails> orderDetailsList = orderDetailsDao.getByUserId(userId);
		orderDetailsList.forEach(orderDetails -> {
			OrderDetailsVO orderDetailsVO = new OrderDetailsVO();
			orderDetailsVO.setOrderId(orderDetails.getId());
			orderDetailsVO.setTimestamp(orderDetails.getTimestamp());
			orderDetailsVO.setUserId(orderDetails.getUserInformation().getUserId());
			orderDetailsVO.setDeliveryAddresses(orderDetails.getDeliveryAddresses());

			List<OrderTrackingVO> orderTrackingVOList = new ArrayList<OrderTrackingVO>();
			List<OrderTracking> orderTrackings = orderDetails.getOrderTrackings();
			orderTrackings.forEach(orderTracking -> {
				OrderTrackingVO orderTrackingVO = new OrderTrackingVO();
				orderTrackingVO.setOrderTrackingId(orderTracking.getId());
				try {
					orderTrackingVO.setOrderDetails(
							objectMapper.readValue(new String(orderTracking.getOrderJson()), RestaurantMenuVO.class));
				} catch (IOException e) {
					e.printStackTrace();
				}
				orderTrackingVOList.add(orderTrackingVO);
			});
			orderDetailsVO.setOrderTrackings(orderTrackingVOList);
			orderDetailsVOList.add(orderDetailsVO);
		});

		return orderDetailsVOList;
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
		Double tax = subTotal * 0.18;
		paymentDetails.put("Sub Total", subTotal);
		paymentDetails.put("tax", tax);
		paymentDetails.put("Grand Total", subTotal + tax);
		return paymentDetails;
	}

	@Override
	public OrderDetails placeOrder(CartVO cartVO) throws Exception {
		OrderDetails orderDetails = new OrderDetails();
		orderDetails.setId(RandomStringUtils.randomAlphanumeric(6));
		orderDetails.setTimestamp(new Date());
		orderDetails.setUserInformation(userInformationDao.get(cartVO.getUserId()));
		// todo: if addressid not given, instead address object is given, then need to
		// insert into address table
		orderDetails.setDeliveryAddresses(addressService.get(cartVO.getAddressId()));

		List<OrderTracking> orderTrackings = new ArrayList<>();
		Set<RestaurantMenuVO> restaurantMenuVOs = cartVO.getOrderDetails();
		restaurantMenuVOs.forEach(restaurantMenuVO -> {
			OrderTracking orderTracking = new OrderTracking();
			orderTracking.setId(RandomStringUtils.randomAlphanumeric(6));
			orderTracking
					.setRestaurantDetails(registrationService.getRestaurantDetails(restaurantMenuVO.getRestaurantId()));
			try {
				orderTracking.setOrderJson(objectMapper.writeValueAsBytes(restaurantMenuVO));
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			orderTrackingDao.add(orderTracking);
			orderTrackings.add(orderTracking);
		});

		orderDetails.setOrderTrackings(orderTrackings);
		orderDetailsDao.add(orderDetails);
		return orderDetails;
		/*
		 * OrderTracking orderTracking = new OrderTracking();
		 * orderTracking.setId(RandomStringUtils.randomAlphanumeric(6));
		 * orderTracking.setOrderJson(objectMapper.writeValueAsBytes(cartVO));
		 * orderTracking.setTimestamp(new Date()); if
		 * (!ObjectUtils.isEmpty(cartVO.getUserId())) {
		 * orderTracking.setUserInformation(userInformationDao.get(cartVO.getUserId()));
		 * } orderTrackingDao.add(orderTracking);
		 */

	}

	@Override
	public OrderDetailsVO reOrder(String orderId) {
		OrderDetails dbOrderDetails = orderDetailsDao.get(orderId);
		OrderDetailsVO orderDetailsVO = new OrderDetailsVO();
		orderDetailsVO.setOrderId(dbOrderDetails.getId());
		orderDetailsVO.setTimestamp(dbOrderDetails.getTimestamp());
		orderDetailsVO.setUserId(dbOrderDetails.getUserInformation().getUserId());
		orderDetailsVO.setDeliveryAddresses(dbOrderDetails.getDeliveryAddresses());

		List<OrderTrackingVO> orderTrackingVOList = new ArrayList<OrderTrackingVO>();
		List<OrderTracking> orderTrackings = dbOrderDetails.getOrderTrackings();
		orderTrackings.forEach(orderTracking -> {
			OrderTrackingVO orderTrackingVO = new OrderTrackingVO();
			orderTrackingVO.setOrderTrackingId(orderTracking.getId());
			try {

				RestaurantMenuVO restaurantMenuVO = objectMapper.readValue(new String(orderTracking.getOrderJson()),
						RestaurantMenuVO.class);
				Set<MenuItemVO> menuItemVOs = restaurantMenuVO.getMenuItems();
				if (!CollectionUtils.isEmpty(menuItemVOs)) {
					List<Long> menuItemIds = menuItemVOs.stream().map(MenuItemVO::getId).collect(Collectors.toList());
					if (!CollectionUtils.isEmpty(menuItemIds)) {
						List<MenuItem> menuItems = menuItemService.getByIds(menuItemIds);
						/**
						 * ? what if reordered menu is no longer supported by restaurant ?
						 */
						// Read more:
						// http://javarevisited.blogspot.com/2016/04/10-examples-of-converting-list-to-map.html#ixzz5DzBFoTkG
						Map<Long, Double> menuDBResults = menuItems.stream()
								.collect(Collectors.toMap(menu -> menu.getId(), menu -> menu.getPrice()));

						menuItemVOs = menuItemVOs.stream().map(menuItemVO -> {
							menuItemVO.setPrice(menuDBResults.get(menuItemVO.getId()));
							menuItemVO.setTotalPrice(menuDBResults.get(menuItemVO.getId()) * menuItemVO.getQuantity());
							return menuItemVO;
						}).collect(Collectors.toSet());
					}
				}

				orderTrackingVO.setOrderDetails(restaurantMenuVO);
			} catch (IOException e) {
				e.printStackTrace();
			}
			orderTrackingVOList.add(orderTrackingVO);
		});
		orderDetailsVO.setOrderTrackings(orderTrackingVOList);
		return orderDetailsVO;

		/*
		 * OrderDetails dbOrderDetails = orderDetailsDao.get(orderId);
		 * 
		 * OrderDetails orderDetails = new OrderDetails();
		 * orderDetails.setId(dbOrderDetails.getId()); orderDetails.setTimestamp(new
		 * Date());
		 * orderDetails.setUserInformation(dbOrderDetails.getUserInformation());
		 * orderDetails.setDeliveryAddresses(dbOrderDetails.getDeliveryAddresses());
		 * 
		 * List<OrderTracking> orderTrackings = new ArrayList<>();
		 * 
		 * List<OrderTracking> dbOrderTrackings = dbOrderDetails.getOrderTrackings();
		 * dbOrderTrackings.forEach(dbOrderTracking -> { OrderTracking orderTracking =
		 * new OrderTracking(); orderTracking.setId(dbOrderTracking.getId());
		 * orderTracking.setRestaurantDetails(dbOrderTracking.getRestaurantDetails());
		 * orderTracking.setOrderJson(dbOrderTracking.getOrderJson()); // todo: need to
		 * add updated, if change in menu // price orderTrackings.add(orderTracking);
		 * });
		 * 
		 * orderDetails.setOrderTrackings(orderTrackings);
		 * 
		 * //orderDetailsDao.add(orderDetails); return orderDetails;
		 */
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
