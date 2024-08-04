package com.blog.myblogapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.myblogapi.payload.UserDTO;
import com.blog.myblogapi.services.UserService;

@RestController
@RequestMapping("api/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/createUser")
	public UserDTO createUsers(@RequestBody UserDTO userDTO){
	UserDTO userdto4=	this.userService.createUser(userDTO);
		return userdto4;
		
	}

}
