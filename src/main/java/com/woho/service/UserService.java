package com.woho.service;

import com.woho.model.UserInformation;
import com.woho.vo.UserVO;

public interface UserService {

	UserInformation getUser(UserVO userVO);
}
