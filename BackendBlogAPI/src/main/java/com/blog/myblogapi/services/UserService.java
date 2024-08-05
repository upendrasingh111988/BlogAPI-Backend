package com.blog.myblogapi.services;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.blog.myblogapi.payload.UserDTO;

public interface UserService {
	
	UserDTO createUser(@RequestBody UserDTO userDTO);
	
	List<UserDTO> getAllBlogUsers();
	
	UserDTO getSingleBlogUser(@PathVariable Integer userid);
	
	UserDTO updateUser(@RequestBody UserDTO userDTO , @PathVariable Integer userid);
	
	void deleteUser(@PathVariable Integer userid);

}
