package com.blog.myblogapi.services;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.blog.myblogapi.payload.CategoryDTO;

public interface CategoryService {

	CategoryDTO createUser(@RequestBody CategoryDTO categoryDTO);
	
	List<CategoryDTO> getAllBlogCategory();
	
	CategoryDTO getSingleBlogCategory(@PathVariable Integer categoryId);
	
	CategoryDTO updateUser(@RequestBody CategoryDTO categoryDTO , @PathVariable Integer categoryId);
	
	void deleteUser(@PathVariable Integer categoryId);
}
