package com.blog.myblogapi.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.myblogapi.model.User;
import com.blog.myblogapi.payload.UserDTO;
import com.blog.myblogapi.services.UserService;
import com.blog.myblogapi.userRepo.UserRepo;
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepo userRepo;

	@Override
	public UserDTO createUser(UserDTO userDTO) {
		
		User user= this.DtoToUser(userDTO);
		User saveduserindb=userRepo.save(user);
		UserDTO userdtos=this.userToDTO(saveduserindb);
		return userdtos;
	}

	public UserDTO userToDTO(User user) {
		UserDTO userDTO= new UserDTO();
		userDTO.setUserid(user.getUserid());
		userDTO.setName(user.getName());
		userDTO.setEmail(user.getEmail());
		userDTO.setAbout(user.getAbout());
		userDTO.setPassword(user.getPassword());
		
		return userDTO;
	}
	
	public User DtoToUser(UserDTO userDto) {
		User user= new User();
		user.setUserid(userDto.getUserid());
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setAbout(userDto.getAbout());
		user.setPassword(userDto.getPassword());
		
		return user;
	}
}
