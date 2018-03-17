package com.woho.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.woho.dao.AbstractDAO;
import com.woho.dao.UserInformationrDao;
import com.woho.model.UserInformation;

@Repository
public class UserInformationDaoImpl extends AbstractDAO<UserInformation> implements UserInformationrDao  {
	
	private static final long serialVersionUID = 1L;
	private final Logger LOG = LoggerFactory.getLogger(getClass());
	
	@Override
	public void addUser(UserInformation user) {
		save(user);
	}


}
