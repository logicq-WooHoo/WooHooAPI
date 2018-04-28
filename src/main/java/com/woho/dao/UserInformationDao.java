package com.woho.dao;

import com.woho.model.UserInformation;

public interface UserInformationDao {

	UserInformation addUser(UserInformation user);

	UserInformation findUserByEmail(String email);

	UserInformation findUserByEmailorMobile(String userName);
	
	UserInformation get(Long id);
	
	UserInformation authenticateUser(String username, String password);

}
