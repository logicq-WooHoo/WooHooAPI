package com.woho.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.woho.model.RestaurantDetails;
import com.woho.service.RegistrationService;
import com.woho.vo.RestaurantMenuVO;
import com.woho.vo.RestaurantSetupVO;

@RestController
@RequestMapping("/api")
public class RegistrationController {

	@Autowired
	RegistrationService registrationService;

	/**
	 * @param type
	 * @param user
	 * @throws Exception 
	 *//*
	@RequestMapping(value = "/user/registration", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public UserVO registerUser(@RequestBody UserInformation userInformation) throws Exception {
		return registrationService.register(userInformation);
	}*/

	/**
	 * 
	 * @param restaurantDetails
	 * @return
	 */
	@RequestMapping(value = "/restaurant/details", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> saveRestaurantDetails(@RequestBody RestaurantDetails restaurantDetails) {
		System.out.println("Adding RestaurantDetails " + restaurantDetails.getRestaurantName());

		if (registrationService.isRestaurantDetailsExist(restaurantDetails)) {
			System.out.println("A RestaurantDetails with registrationNumber "
					+ restaurantDetails.getRegistrationNumber() + " already exist");
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}

		registrationService.saveRestaurantDetails(restaurantDetails);

		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	/**
	 * Retrieve Single RestaurantDetails
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/restaurant/details/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RestaurantDetails> getRestaurantDetails(@PathVariable("id") long id) {
		System.out.println("Fetching RestaurantDetails with id " + id);
		RestaurantDetails restaurantDetails = registrationService.getRestaurantDetails(id);
		if (null == restaurantDetails) {
			System.out.println("RestaurantDetails with id " + id + " not found");
			return new ResponseEntity<RestaurantDetails>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<RestaurantDetails>(restaurantDetails, HttpStatus.OK);

	}

	/**
	 * Retrieve All RestaurantDetails
	 * 
	 * @return
	 */
	@RequestMapping(value = "/restaurant/details/", method = RequestMethod.GET)
	public ResponseEntity<List<RestaurantDetails>> listAllRestaurantDetails() {
		List<RestaurantDetails> restaurantDetailsList = registrationService.listAllRestaurantDetails();
		if (restaurantDetailsList.isEmpty()) {
			return new ResponseEntity<List<RestaurantDetails>>(HttpStatus.NO_CONTENT);// You many decide to return
			// HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<List<RestaurantDetails>>(restaurantDetailsList, HttpStatus.OK);
	}

	/**
	 * Delete a RestaurantDetails
	 * 
	 * @param id
	 * @return RestaurantDetails
	 */
	@RequestMapping(value = "/restaurant/details/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<RestaurantDetails> deleteRestaurantDetails(@PathVariable("id") long id) {
		System.out.println("Fetching & Deleting RestaurantDetails with id " + id);

		RestaurantDetails restaurantDetails = registrationService.getRestaurantDetails(id);
		if (restaurantDetails == null) {
			System.out.println("Unable to delete. RestaurantDetails with id " + id + " not found");
			return new ResponseEntity<RestaurantDetails>(HttpStatus.NOT_FOUND);
		}

		registrationService.deleteRestaurantDetails(id);
		return new ResponseEntity<RestaurantDetails>(HttpStatus.NO_CONTENT);
	}

	/**
	 * Update a RestaurantDetails
	 * 
	 * @param id
	 * @param user
	 * @return RestaurantDetails
	 */
	@RequestMapping(value = "/restaurant/details/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RestaurantDetails> updateRestaurantDetails(@PathVariable("id") long id,
			@RequestBody RestaurantDetails restaurantDetails) {
		System.out.println("Updating RestaurantDetails " + id);

		RestaurantDetails currentRestaurantDetails = registrationService.getRestaurantDetails(id);

		if (currentRestaurantDetails == null) {
			System.out.println("RestaurantDetails with id " + id + " not found");
			return new ResponseEntity<RestaurantDetails>(HttpStatus.NOT_FOUND);
		}

		registrationService.updateRestaurantDetails(id, restaurantDetails);
		return new ResponseEntity<RestaurantDetails>(restaurantDetails, HttpStatus.OK);
	}

	/**
	 * 
	 * @param file
	 * @param model
	 */
	@RequestMapping(value = "/uploadtest", method = RequestMethod.POST)
	public void registerRestaurantDetailsUploadTest(@RequestParam("file") MultipartFile file, Model model) {
		registrationService.registerRestaurantDetailsUploadTest(file);
	}

	@RequestMapping(value = "/restaurant/setup", method = RequestMethod.POST, consumes = "application/json")
	public void registerRestaurantSetup(@RequestBody RestaurantSetupVO restaurantSetupVO)
			throws JsonProcessingException {
		registrationService.registerRestaurantSetup(restaurantSetupVO);
	}

	@RequestMapping(value = "/restaurant/menu", method = RequestMethod.POST, consumes = "application/json")
	public void registerRestaurantMenu(@RequestBody RestaurantMenuVO restaurantMenuVO) throws JsonProcessingException {
		registrationService.registerRestaurantMenu(restaurantMenuVO);
	}

}
