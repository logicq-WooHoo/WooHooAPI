package com.woho.vo;

import com.woho.model.RestaurantDetails;
import com.woho.model.UserInformation;

public class FinalSetUpVO {

	
	UserInformation userInformation;
	
	RestaurantDetails restaurantDetails;
	
	RestaurantMenuVO restaurantMenuVO;
	
	RestaurantSetupVO restaurantSetupVO;

	public UserInformation getUserInformation() {
		return userInformation;
	}

	public void setUserInformation(UserInformation userInformation) {
		this.userInformation = userInformation;
	}


	public RestaurantDetails getRestaurantDetails() {
		return restaurantDetails;
	}

	public void setRestaurantDetails(RestaurantDetails restaurantDetails) {
		this.restaurantDetails = restaurantDetails;
	}

	public RestaurantMenuVO getRestaurantMenuVO() {
		return restaurantMenuVO;
	}

	public void setRestaurantMenuVO(RestaurantMenuVO restaurantMenuVO) {
		this.restaurantMenuVO = restaurantMenuVO;
	}

	public RestaurantSetupVO getRestaurantSetupVO() {
		return restaurantSetupVO;
	}

	public void setRestaurantSetupVO(RestaurantSetupVO restaurantSetupVO) {
		this.restaurantSetupVO = restaurantSetupVO;
	}
	
}
