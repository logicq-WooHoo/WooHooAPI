package com.woho.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.woho.dao.AbstractDAO;
import com.woho.dao.UserInformationDao;
import com.woho.model.UserInformation;

@Repository
public class UserInformationDaoImpl extends AbstractDAO<UserInformation> implements UserInformationDao {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5913662788318515611L;
	private final Logger LOG = LoggerFactory.getLogger(getClass());

	@Override
	public UserInformation addUser(UserInformation user) {
		save(user);
		return user;
	}

	@Override
	public UserInformation findUserByEmail(String email) {
		StringBuilder selectQuery = new StringBuilder();
		selectQuery.append("from UserInformation u where u.emailId='" + email + "'");
		return executeQueryForUniqueRecord(selectQuery.toString());
	}

	@Override
	public UserInformation get(Long id) {
		return getRecordById(UserInformation.class, id);
	}

	@Override
	public UserInformation findUserByEmailorMobile(String userName) {
		StringBuilder selectQuery = new StringBuilder();
		if (userName.matches("[0-9]+") && userName.length() > 2) {
			selectQuery.append("from UserInformation u where u.mobileNo='" + userName + "'");
		} else {
			selectQuery.append("from UserInformation u where u.emailId='" + userName + "'");
		}
		return executeQueryForUniqueRecord(selectQuery.toString());
	}

	@Override
	public UserInformation authenticateUser(String username, String password) {
		StringBuilder selectQuery = new StringBuilder();
		if (username.matches("[0-9]+") && username.length() > 2) {
			selectQuery.append("from UserInformation u where u.mobileNo='" + username + "'");
		} else {
			selectQuery.append("from UserInformation u where u.emailId='" + username + "'");
		}
		selectQuery.append(" and u.password='" + password + "'");
		return executeQueryForUniqueRecord(selectQuery.toString());
	}

}
