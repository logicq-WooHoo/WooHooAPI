package com.woho.vo;

import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.woho.model.Address;
import com.woho.model.UserInformation;

@JsonInclude(Include.NON_NULL)
public class UserVO {

	private String username;

	private String firstName;

	private String lastName;

	private String emailId;

	private String mobileNo;

	private String type;

	private String loginType;

	private UserInformation userInformation;

	private List<PaymentCardVO> paymentCards;

	private Set<Address> addresses;

	Address address;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public UserInformation getUserInformation() {
		return userInformation;
	}

	public void setUserInformation(UserInformation userInformation) {
		this.userInformation = userInformation;
	}

	public List<PaymentCardVO> getPaymentCards() {
		return paymentCards;
	}

	public void setPaymentCards(List<PaymentCardVO> paymentCards) {
		this.paymentCards = paymentCards;
	}

	public String getLoginType() {
		return loginType;
	}

	public void setLoginType(String loginType) {
		this.loginType = loginType;
	}

	public Set<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "UserVO [username=" + username + ", firstName=" + firstName + ", lastName=" + lastName + ", emailId="
				+ emailId + ", mobileNo=" + mobileNo + ", type=" + type + ", loginType=" + loginType
				+ ", userInformation=" + userInformation + ", paymentCards=" + paymentCards + ", addresses=" + addresses
				+ ", address=" + address + "]";
	}

}
