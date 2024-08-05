package com.blog.myblogapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.myblogapi.payload.UserDTO;
import com.blog.myblogapi.response.ApiResponse;
import com.blog.myblogapi.services.UserService;
import com.blog.myblogapi.userRepo.UserRepo;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/createUser")
	public ResponseEntity<UserDTO> createUsers(@Valid @RequestBody UserDTO userDTO){
	UserDTO userdto4=	this.userService.createUser(userDTO);
		return new ResponseEntity<>(userdto4,HttpStatus.CREATED);
		
	}
	
	@GetMapping("")
	public ResponseEntity<List<UserDTO>> getAllBlogUsers(){
	
		return ResponseEntity.ok(userService.getAllBlogUsers());
	}
	
	@GetMapping("/{userid}")
	public ResponseEntity<UserDTO> getsingleUser(@PathVariable Integer userid){
		
	UserDTO userDTO=userService.getSingleBlogUser(userid);
	
	return ResponseEntity.ok(userDTO);
	}
	
	@PutMapping("/{userid}")
	public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO userDTO , @PathVariable Integer userid){
		
	UserDTO userDTO2=userService.updateUser(userDTO, userid);
	
	return ResponseEntity.ok(userDTO2);
	}

	@DeleteMapping("/{userid}")
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable Integer userid){
		userService.deleteUser(userid);
		
		return new ResponseEntity<ApiResponse>( new ApiResponse("User deleted successfully..",true),HttpStatus.OK);
	}
}
