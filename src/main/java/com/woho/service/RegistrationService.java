package com.woho.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.woho.model.Address;
import com.woho.model.RestaurantDetails;
import com.woho.vo.RestaurantMenuVO;
import com.woho.vo.RestaurantSetupVO;

public interface RegistrationService {
	
	//UserVO register(UserInformation user) throws Exception;
	RestaurantDetails saveRestaurantDetails(RestaurantDetails restaurantDetails);
	RestaurantDetails getRestaurantDetails(long id);
	RestaurantDetails getRestaurantDetailsByRegistrationNumber(String registrationNumber);
	List<RestaurantDetails> listAllRestaurantDetails();
	void deleteRestaurantDetails(long id);
	void updateRestaurantDetails(long id, RestaurantDetails restaurantDetails);
	public boolean isRestaurantDetailsExist(RestaurantDetails restaurantDetails);
	List<RestaurantDetails> getByAddressList(List<Address> addresses);
	
	void registerRestaurantDetailsUploadTest(MultipartFile file);
	void registerRestaurantSetup(RestaurantSetupVO restaurantSetup) throws JsonProcessingException;
	void registerRestaurantMenu(RestaurantMenuVO restaurantMenuVO) throws JsonProcessingException;

	
}
