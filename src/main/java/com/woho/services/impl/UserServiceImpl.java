package com.woho.services.impl;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.woho.dao.UserDao;
import com.woho.model.UserInformation;
import com.woho.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	UserDao userRepository;
	
	@Override
	public UserInformation getUser(String userId) {
		return userRepository.findByUserId(userId);
	}

	@Override
	public void updateUser(UserInformation user) {
		userRepository.updateUser(user);
	}
}
