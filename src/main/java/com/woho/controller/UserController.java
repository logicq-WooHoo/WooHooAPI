package com.woho.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.woho.model.UserInformation;
import com.woho.service.UserService;

@RestController
@RequestMapping("/user/api")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value="/profile/user/update", method=RequestMethod.POST, consumes="application/json")
	public void updateUserInformation(@RequestBody UserInformation user) {
		userService.updateUser(user);
	}
	
	@RequestMapping(value="/registration", method=RequestMethod.POST, consumes="application/json")
	public void register(@RequestBody UserInformation user) {
		userService.updateUser(user);
	}

}
