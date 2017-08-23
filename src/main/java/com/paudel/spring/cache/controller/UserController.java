package com.paudel.spring.cache.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paudel.spring.cache.model.User;
import com.paudel.spring.cache.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;

	@RequestMapping(value ="rest/users/{userid}")
	public User getUsers(@PathVariable("userid") String userId){
		return userService.getUser(userId);
	}
	

}
