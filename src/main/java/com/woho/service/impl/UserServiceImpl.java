package com.woho.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woho.dao.UserInformationrDao;
import com.woho.model.UserInformation;
import com.woho.service.UserService;
import com.woho.vo.UserVO;

@Service
@Transactional
public class UserServiceImpl implements  UserService{
	
	@Autowired
	UserInformationrDao userInformationrDao;

	@Override
	public UserInformation getUser(UserVO userVO) {

		UserInformation userInformation = userInformationrDao.findUserByEmail(userVO.getEmailId());

		return userInformation;

	}

}
