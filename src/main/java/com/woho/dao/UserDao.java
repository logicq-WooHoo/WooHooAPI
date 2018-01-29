package com.woho.dao;

import com.woho.model.UserInformation;


public interface UserDao 
{
	public UserInformation findByUserId(String userId) ;
	
	public void updateUser(UserInformation user) ;
	
	public void deleteUser(UserInformation user) ;
}
