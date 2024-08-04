package com.blog.myblogapi.userRepo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.myblogapi.model.User;

public interface UserRepo extends JpaRepository<User, Integer> {

}
