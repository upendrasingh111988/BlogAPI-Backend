package com.blog.myblogapi.userRepo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.myblogapi.model.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer> {

}
