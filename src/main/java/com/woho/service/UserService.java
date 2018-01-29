package com.woho.service;

import com.woho.model.UserInformation;

public interface UserService {
	UserInformation getUser(String userId) ;
	
	void updateUser(UserInformation user);

}
