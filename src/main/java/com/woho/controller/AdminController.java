package com.woho.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.woho.model.DeliveryPartner;
import com.woho.model.FoodCategory;
import com.woho.model.FoodServiceType;
import com.woho.model.RestaurantType;
import com.woho.model.UserInformation;
import com.woho.service.DeliveryPartnerService;
import com.woho.service.FinalSetUpService;
import com.woho.service.FoodCategoryService;
import com.woho.service.FoodServiceTypeService;
import com.woho.service.RestaurantTypeService;
import com.woho.vo.FinalSetUpVO;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	DeliveryPartnerService deliveryPartnerService;
	
	@Autowired
	RestaurantTypeService restaurantTypeService;
	
	@Autowired
	FoodServiceTypeService foodServiceTypeService;
	
	@Autowired
	FoodCategoryService foodCategoryService;
	
	@Autowired
	FinalSetUpService finalSetUpService;
	
	
	@RequestMapping(value = "/adddeliverypartner", method = RequestMethod.POST, consumes = "application/json")
	public void createDeliveryPartner(@RequestBody DeliveryPartner deliveryPartner) throws JsonProcessingException {
		deliveryPartnerService.addDeliveryPartner(deliveryPartner);
	}
	
	@RequestMapping(value = "/deletedeliverypartner", method = RequestMethod.POST, consumes = "application/json")
	public void deleteDeliveryPartner(@RequestBody DeliveryPartner deliveryPartner) throws JsonProcessingException {
		deliveryPartnerService.deleteDeliveryPartner(deliveryPartner);
	}
	
	@RequestMapping(value = "/updatedeliverypartner", method = RequestMethod.POST, consumes = "application/json")
	public void updateDeliveryPartner(@RequestBody DeliveryPartner deliveryPartner) throws JsonProcessingException {
		deliveryPartnerService.updateDeliveryPartner(deliveryPartner);
	}
	
	
	/**
	 * 
	 * @param deliveryPartner
	 * @throws JsonProcessingException
	 */
	@RequestMapping(value = "/addrestauranttype", method = RequestMethod.POST, consumes = "application/json")
	public void createRestaurantType(@RequestBody RestaurantType restaurentType) throws JsonProcessingException {
		restaurantTypeService.addRestaurentType(restaurentType);
	}
	
	@RequestMapping(value = "/deleterestauranttype", method = RequestMethod.POST, consumes = "application/json")
	public void deleteRestaurantType(@RequestBody RestaurantType restaurentType) throws JsonProcessingException {
		restaurantTypeService.deleteRestaurentType(restaurentType);
	}
	
	@RequestMapping(value = "/updaterestauranttype", method = RequestMethod.POST, consumes = "application/json")
	public void updateRestaurantType(@RequestBody RestaurantType restaurentType) throws JsonProcessingException {
		restaurantTypeService.updateRestaurentType(restaurentType);
	}
	
	
	/**
	 * 
	 * @param foodServiceType
	 * @throws JsonProcessingException
	 */
	@RequestMapping(value = "/addfoodservicetype", method = RequestMethod.POST, consumes = "application/json")
	public void createFoodServiceType(@RequestBody FoodServiceType foodServiceType) throws JsonProcessingException {
		foodServiceTypeService.addFoodServiceType(foodServiceType);
	}
	
	@RequestMapping(value = "/deletefoodservicetype", method = RequestMethod.POST, consumes = "application/json")
	public void deleteFoodServiceType(@RequestBody FoodServiceType foodServiceType) throws JsonProcessingException {
		foodServiceTypeService.deleteFoodServiceType(foodServiceType);
	}
	
	@RequestMapping(value = "/updatefoodservicetype", method = RequestMethod.POST, consumes = "application/json")
	public void updateFoodServiceType(@RequestBody FoodServiceType foodServiceType) throws JsonProcessingException {
		foodServiceTypeService.updateFoodServiceType(foodServiceType);
	}
	
	
	/**
	 * 
	 * @param foodCategory
	 * @throws JsonProcessingException
	 */
	@RequestMapping(value = "/addfoodcategory", method = RequestMethod.POST, consumes = "application/json")
	public void createFoodCategory(@RequestBody FoodCategory foodCategory) throws JsonProcessingException {
		foodCategoryService.addFoodCategory(foodCategory);
	}
	
	@RequestMapping(value = "/deletefoodcategory", method = RequestMethod.POST, consumes = "application/json")
	public void deleteFoodServiceType(@RequestBody FoodCategory foodCategory) throws JsonProcessingException {
		foodCategoryService.deleteFoodCategory(foodCategory);
	}
	
	@RequestMapping(value = "/updatefoodcategory", method = RequestMethod.POST, consumes = "application/json")
	public void updateFoodServiceType(@RequestBody FoodCategory foodCategory) throws JsonProcessingException {
		foodCategoryService.updateFoodCategory(foodCategory);
	}
	
	
	
	@RequestMapping(value = "/finalsetup", method = RequestMethod.POST,  produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<FinalSetUpVO> finalRestaurentSetup(@RequestBody FinalSetUpVO finalSetUpVO) throws Exception {

		finalSetUpService.finalRestaurentSetup(finalSetUpVO);
		
		return new ResponseEntity<FinalSetUpVO>(finalSetUpVO, HttpStatus.OK);
	
	}

}
