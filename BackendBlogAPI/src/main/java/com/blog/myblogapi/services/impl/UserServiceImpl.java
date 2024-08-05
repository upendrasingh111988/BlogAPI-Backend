package com.blog.myblogapi.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.myblogapi.exception.ResourceNotFoundException;
import com.blog.myblogapi.model.User;
import com.blog.myblogapi.payload.UserDTO;
import com.blog.myblogapi.services.UserService;
import com.blog.myblogapi.userRepo.UserRepo;
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public UserDTO createUser(UserDTO userDTO) {
		
		User user= this.DtoToUser(userDTO);
		User saveduserindb=userRepo.save(user);
		UserDTO userdtos=this.userToDTO(saveduserindb);
		return userdtos;
	}
	
// get All Users
	@Override
	public List<UserDTO> getAllBlogUsers() {
		List<User>users=userRepo.findAll();
		List<UserDTO>mappedusers=	users.stream().map(user->this.userToDTO(user)).collect(Collectors.toList());
		return mappedusers;
	}
	
	@Override
	public UserDTO getSingleBlogUser(Integer userid) {
		User user=userRepo.findById(userid)
				.orElseThrow(()-> new ResourceNotFoundException("user","id",userid));
		return this.userToDTO(user);
	}

	@Override
	public UserDTO updateUser(UserDTO userDTO, Integer userid) {
		User user1=userRepo.findById(userid)
				.orElseThrow(()-> new ResourceNotFoundException("user", "id", userid));
		//user1.setUserid(userDTO.getUserid());
		user1.setName(userDTO.getName());
		user1.setEmail(userDTO.getEmail());
		user1.setAbout(userDTO.getAbout());
		user1.setPassword(userDTO.getPassword());
	User saveduserafterupdate=userRepo.save(user1);
	UserDTO indtoformuser=this.userToDTO(saveduserafterupdate);
		return indtoformuser;
	}

	public UserDTO userToDTO(User user) {
		/*
		 * UserDTO userDTO= new UserDTO(); userDTO.setUserid(user.getUserid());
		 * userDTO.setName(user.getName()); userDTO.setEmail(user.getEmail());
		 * userDTO.setAbout(user.getAbout()); userDTO.setPassword(user.getPassword());
		 */
		
		UserDTO userDTO= this.modelMapper.map(user, UserDTO.class);
		
			return userDTO;
	}
	
	public User DtoToUser(UserDTO userDto) {
		
		User user= this.modelMapper.map(userDto, User.class);
		/*
		 * user.setUserid(userDto.getUserid()); user.setName(userDto.getName());
		 * user.setEmail(userDto.getEmail()); user.setAbout(userDto.getAbout());
		 * user.setPassword(userDto.getPassword());
		 */
		
		return user;
	}

	@Override
	public void deleteUser(Integer userid) {
		User user= userRepo.findById(userid)
				.orElseThrow(()-> new ResourceNotFoundException("User", "id", userid));
		userRepo.delete(user);
		
	}



}
