package com.blog.myblogapi.userRepo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.myblogapi.model.Role;

public interface RoleRepo extends JpaRepository<Role, Integer> {

}
