package com.blog.myblogapi.services;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.blog.myblogapi.payload.UserDTO;

public interface UserService {
	
	UserDTO registerNewUser(UserDTO userDTO);
	
	UserDTO createUser(UserDTO userDTO);
	
	List<UserDTO> getAllBlogUsers();
	
	UserDTO getSingleBlogUser(Integer userid);
	
	UserDTO updateUser( UserDTO userDTO , Integer userid);
	
	void deleteUser(@PathVariable Integer userid);

}
