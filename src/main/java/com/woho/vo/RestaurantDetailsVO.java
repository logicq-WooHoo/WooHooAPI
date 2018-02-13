package com.woho.vo;

import org.springframework.web.multipart.MultipartFile;

import com.woho.model.Address;
import com.woho.model.UserInformation;

/**
 * 
 * @author Pankaj Labade
 *
 */
public class RestaurantDetailsVO {
	
	private Long id;
	
	private String restaurantName;
	
	private String registrationNumber;
	
	private MultipartFile file;
	
	private Address address;

	private UserInformation userInformation;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public UserInformation getUserInformation() {
		return userInformation;
	}

	public void setUserInformation(UserInformation userInformation) {
		this.userInformation = userInformation;
	}

	@Override
	public String toString() {
		return "RestaurantDetailsVO [id=" + id + ", restaurantName=" + restaurantName + ", registrationNumber="
				+ registrationNumber + ", file=" + file + ", address=" + address + ", userInformation="
				+ userInformation + "]";
	}

}
