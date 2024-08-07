package com.blog.myblogapi.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.myblogapi.exception.ResourceNotFoundException;
import com.blog.myblogapi.model.Category;
import com.blog.myblogapi.payload.CategoryDTO;
import com.blog.myblogapi.services.CategoryService;
import com.blog.myblogapi.userRepo.CategoryRepo;
@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryRepo categoryRepo;
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CategoryDTO createUser(CategoryDTO categoryDTO) {
		Category cat= this.modelMapper.map(categoryDTO, Category.class);
		Category cateadd=categoryRepo.save(cat);
		return this.modelMapper.map(cateadd, CategoryDTO.class);
	}

	@Override
	public List<CategoryDTO> getAllBlogCategory() {
		List<Category> categories= categoryRepo.findAll();
		List<CategoryDTO> mymappedcategory=	categories.stream()
			.map((cat)->this.modelMapper.map(cat, CategoryDTO.class)).collect(Collectors.toList());
		return mymappedcategory;
	}

	

	@Override
	public CategoryDTO updateUser(CategoryDTO categoryDTO, Integer categoryId) {
		Category cate2= categoryRepo.findById(categoryId)
				.orElseThrow(()-> new ResourceNotFoundException("Category", "categoryId",categoryId));
		//cate2.setCategoryId(categoryDTO.getCategoryId());
		cate2.setCategoryTitle(categoryDTO.getCategoryTitle());
		cate2.setCategoryDescription(categoryDTO.getCategoryDescription());
		
		Category updateddataafterdbsave= categoryRepo.save(cate2);
		
		return this.modelMapper.map(updateddataafterdbsave, CategoryDTO.class);
	}

	@Override
	public void deleteUser(Integer categoryId) {
		Category cate= categoryRepo.findById(categoryId)
				.orElseThrow(()-> new ResourceNotFoundException("category", "categoryId", categoryId));
		categoryRepo.delete(cate);
	}

	@Override
	public CategoryDTO getSingleBlogCategory(Integer categoryId) {
		Category cate= categoryRepo.findById(categoryId)
				.orElseThrow(()-> new ResourceNotFoundException("category", "categoryId", categoryId));
		
		return this.modelMapper.map(cate, CategoryDTO.class);
	}

}
