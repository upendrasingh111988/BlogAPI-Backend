package com.blog.myblogapi.config;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.stereotype.Service;

import com.blog.myblogapi.exception.ResourceNotFoundException;
import com.blog.myblogapi.model.User;
import com.blog.myblogapi.userRepo.UserRepo;


@Service
public class UserDetailsServiceConfig  implements UserDetailsService{

	@Autowired
	 private UserRepo userRepository;

		/*
		 * public UserDetailsServiceConfig(UserRepo userRepository) {
		 * this.userRepository = userRepository; }
		 */
	    @Override
	    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	        User user = userRepository.findByEmail(username).orElseThrow(()-> new ResourceNotFoundException("", "", 0));
	        return user;
	    }
}
