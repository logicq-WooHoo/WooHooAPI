package com.woho.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.woho.model.Address;
import com.woho.model.OrderDetails;
import com.woho.model.UserInformation;
import com.woho.service.AddressService;
import com.woho.service.UserService;
import com.woho.vo.CartVO;
import com.woho.vo.OrderDetailsVO;
import com.woho.vo.PaymentCardVO;
import com.woho.vo.UserVO;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	UserService userService;
	@Autowired
	AddressService addressService;;

	/**
	 * @param type
	 * @param user
	 * @throws Exception
	 */
	@RequestMapping(value = "/user/registration", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public UserVO registerUser(@RequestBody UserInformation userInformation) throws Exception {
		return userService.addUser(userInformation);
	}

	@RequestMapping(value = "/user/{emailId:.+}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public UserVO getUserByEmailId(@PathVariable("emailId") String emailId) throws Exception {
		return userService.getUserByEmailId(emailId);
	}

	@RequestMapping(value = "/user/getpastorders/{userId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<OrderDetailsVO> getPastOrders(@PathVariable("userId") Long userId) throws Exception {
		return userService.getPastOrders(userId);
	}

	@RequestMapping(value = "/user/myorders/{emailId:.+}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<OrderDetailsVO> getPastOrders(@PathVariable("emailId") String emailId) throws Exception {
		return userService.getPastOrders(emailId);
	}

	@RequestMapping(value = "/user/placeorder", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public OrderDetails placeOrder(@RequestBody CartVO cartVO) throws Exception {
		return userService.placeOrder(cartVO);
	}

	@RequestMapping(value = "/user/reorder/{orderId}", method = RequestMethod.GET)
	public OrderDetailsVO reOrder(@PathVariable("orderId") String orderId) throws Exception {
		return userService.reOrder(orderId);
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

	@RequestMapping(value = "/user/myprofile/{emailId:.+}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public UserVO getMyProfile(@PathVariable("emailId") String emailId) throws Exception {
		return userService.getMyProfile(emailId);
	}

	/*********************************************************
	 * User address APIs
	 */

	/**
	 * 
	 * @param address
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/user/address", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Set<Address>> addAddress(@RequestBody UserVO userVO) throws Exception {
		// Address addressToSave = addressService.add(address);
		Set<Address> addresses = userService.addAddress(userVO);
		// List<Address> addresses = addressService.list();

		if (CollectionUtils.isEmpty(addresses)) {
			return new ResponseEntity<Set<Address>>(HttpStatus.NO_CONTENT);// You many decide to return
			// HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<Set<Address>>(addresses, HttpStatus.CREATED);
	}

	/**
	 * 
	 * @param id
	 * @return
	 *//*
	@RequestMapping(value = "/user/address/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Address> getAddressDetails(@PathVariable("id") Long id) {
		System.out.println("Fetching Address with id " + id);
		Address address = addressService.get(id);

		if (ObjectUtils.isEmpty(address)) {
			System.out.println("Address with id " + id + " not found");
			return new ResponseEntity<Address>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Address>(address, HttpStatus.OK);

	}*/

	/**
	 * 
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "/user/address/{emailId:.+}", method = RequestMethod.GET)
	public ResponseEntity<Set<Address>> listAllAddresses(@PathVariable("emailId") String emailId) throws Exception {
		Set<Address> addresses = userService.getUserAddresses(emailId);

		if (CollectionUtils.isEmpty(addresses)) {
			return new ResponseEntity<Set<Address>>(HttpStatus.NO_CONTENT);// You many decide to return
			// HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<Set<Address>>(addresses, HttpStatus.OK);
	}

	/**
	 * 
	 * @param id
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "/user/address/{id}/{emailId:.+}", method = RequestMethod.DELETE)
	public ResponseEntity<Set<Address>> deleteAddress(@PathVariable("id") Long id, @PathVariable("emailId") String emailId) throws Exception {
		System.out.println("Fetching & Deleting Address with id " + id);
		Address address = addressService.get(id);
		if (ObjectUtils.isEmpty(address)) {
			System.out.println("Address with id " + id + " not found");
			return new ResponseEntity<Set<Address>>(HttpStatus.NOT_FOUND);
		}
		addressService.delete(id);
		Set<Address> addresses = userService.getUserAddresses(emailId);
		return new ResponseEntity<Set<Address>>(HttpStatus.NO_CONTENT);
	}

	/**
	 * 
	 * @param id
	 * @param address
	 * @return
	 */
	@RequestMapping(value = "/user/address/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Address> updateAddressDetails(@PathVariable("id") Long id,
			@RequestBody Address address) {
		System.out.println("Updating Address " + id);
		Address currentAddress = addressService.get(id);
		if (ObjectUtils.isEmpty(currentAddress)) {
			System.out.println("Address with id " + id + " not found");
			return new ResponseEntity<Address>(HttpStatus.NOT_FOUND);
		}
		addressService.update(id, address);
		return new ResponseEntity<Address>(address, HttpStatus.OK);
	}
}
