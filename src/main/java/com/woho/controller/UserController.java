package com.woho.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.woho.service.UserService;
import com.woho.vo.OrderDetailsVO;
import com.woho.vo.OrderTrackingVO;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	UserService userService;

	@RequestMapping(value = "/user/getpastorders/{userId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<OrderTrackingVO> getPastOrders(@PathVariable("userId") Long userId) throws Exception {
		return userService.getpastorders(userId);
	}

	@RequestMapping(value = "/user/getorderdetails/{trackingId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Set<OrderDetailsVO> getOrderDetails(@PathVariable("trackingId") String trackingId) throws Exception {
		return userService.getOrderDetails(trackingId);
	}
}
