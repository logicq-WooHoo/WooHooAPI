package com.woho.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.woho.model.UserInformation;
import com.woho.service.UserService;

@RestController
@EnableAutoConfiguration
@RequestMapping("/api")
public class LoginController {

	@Autowired
	HttpServletRequest request;
	@Autowired
	UserService userService;

	/*
	 * @RequestMapping(value = "/login", method = RequestMethod.POST, produces =
	 * MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
	 * public ResponseEntity<UserInformation> login(@RequestBody UserVO userVO)
	 * throws Exception {
	 * 
	 * UserInformation validateUser = userService.getUser(userVO);
	 * 
	 * if (null != validateUser) { return new
	 * ResponseEntity<UserInformation>(validateUser, HttpStatus.OK);
	 * 
	 * } else { return new ResponseEntity<UserInformation>(validateUser,
	 * HttpStatus.UNAUTHORIZED); } }
	 */

	@RequestMapping(value = "/login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserInformation> login(@RequestBody UserInformation userinfo) throws Exception {
		// UserVO userVO = new UserVO();
	//	UserInformation validUser = null;

		//String username = (String) request.getHeader("username");
		//String password = (String) request.getHeader("password");
		UserInformation validUser = userService.authenticateUser(userinfo.getEmailId(), userinfo.getPassword());
		if (!ObjectUtils.isEmpty(validUser)) {
			validUser.setPassword(null);
		} else {
			throw new Exception("Username or passowrd may be incorrect");
		}

		/*
		 * if (uservo.getUsername().equals(username)) {
		 * usrDetails.setActive(Boolean.TRUE);
		 * usrDetails.setAddress(uservo.getAddress());
		 * usrDetails.setCity(uservo.getCity());
		 * usrDetails.setCountry(uservo.getCountry());
		 * usrDetails.setEmail(uservo.getEmail());
		 * usrDetails.setFirstname(uservo.getEmail());
		 * usrDetails.setLastname(uservo.getLastname());
		 * usrDetails.setMobileno(uservo.getMobileno());
		 * usrDetails.setPostalcode(uservo.getPostalcode());
		 * usrDetails.setUsername(uservo.getUsername()); } else { throw new
		 * Exception(" Username or passowrd may be incorrect"); }
		 */
		return new ResponseEntity<UserInformation>(validUser, HttpStatus.OK);
	}
}
