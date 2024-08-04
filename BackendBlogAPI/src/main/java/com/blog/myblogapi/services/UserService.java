package com.blog.myblogapi.services;

import org.springframework.web.bind.annotation.RequestBody;

import com.blog.myblogapi.payload.UserDTO;

public interface UserService {
	
	UserDTO createUser(@RequestBody UserDTO userDTO);

}
