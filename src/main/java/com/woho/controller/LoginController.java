package com.woho.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.woho.model.UserInformation;
import com.woho.service.UserService;
import com.woho.vo.UserVO;


@RestController
public class LoginController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserInformation> login(@RequestBody UserVO userVO) throws Exception {

		UserInformation validateUser = userService.getUser(userVO);

		if (null != validateUser) {
			return new ResponseEntity<UserInformation>(validateUser, HttpStatus.OK);

		} else {
			return new ResponseEntity<UserInformation>(validateUser, HttpStatus.UNAUTHORIZED);
		}
	}
}
