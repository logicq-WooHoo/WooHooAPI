package com.woho.dao;

import com.woho.model.UserInformation;

public interface UserInformationDao {

	UserInformation addUser(UserInformation user);

	UserInformation findUserByEmail(String email);

	UserInformation get(Long id);

}