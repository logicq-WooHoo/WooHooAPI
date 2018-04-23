package com.woho.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.woho.service.UserService;
import com.woho.vo.CartVO;
import com.woho.vo.OrderTrackingVO;
import com.woho.vo.PaymentCardVO;
import com.woho.vo.UserVO;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	UserService userService;

	@RequestMapping(value = "/user/getpastorders/{userId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<OrderTrackingVO> getPastOrders(@PathVariable("userId") Long userId) throws Exception {
		return userService.getpastorders(userId);
	}

	@RequestMapping(value = "/user/placeorder", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public void placeOrder(@RequestBody CartVO cartVO) throws Exception {
		userService.placeOrder(cartVO);;
	}
	
	@RequestMapping(value = "/user/reorder/{trackingId}", method = RequestMethod.GET)
	public void reOrder(@PathVariable("trackingId") String trackingId) throws Exception {
		userService.reOrder(trackingId);
	}
	
	@RequestMapping(value = "/user/gettotalbillwithtax", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Double> getTotalBillWithTax(Double subTotal) throws Exception {
		return userService.getTotalBillWithTax(subTotal);
	}
	
	@RequestMapping(value = "/user/savecarddetails", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void saveCardDetails(@RequestBody PaymentCardVO paymentCardVO) throws Exception {
		userService.saveCardDetails(paymentCardVO);
	}
	
	@RequestMapping(value = "/user/getmyprofile/{userId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public UserVO getMyProfile(@PathVariable("userId") Long userId) throws Exception {
		return userService.getMyProfile(userId);
	}
}
