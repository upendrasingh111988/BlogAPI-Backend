package com.blog.myblogapi.userRepo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.myblogapi.model.User;

public interface UserRepo extends JpaRepository<User, Integer> {

	Optional<User> findByEmail(String email);
}
