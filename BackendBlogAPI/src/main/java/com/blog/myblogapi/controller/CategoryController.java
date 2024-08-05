package com.blog.myblogapi.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
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

import com.blog.myblogapi.payload.CategoryDTO;
import com.blog.myblogapi.response.ApiResponse;
import com.blog.myblogapi.services.CategoryService;

@RestController
@RequestMapping("api/categories")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private ModelMapper modelMapper;
	
	@PostMapping("/createcat")
	public ResponseEntity<CategoryDTO> createCategory(@RequestBody CategoryDTO categoryDTO){
		
		CategoryDTO categoryDTO2=categoryService.createUser(categoryDTO);
		
		return new ResponseEntity<CategoryDTO>(categoryDTO2,HttpStatus.CREATED);
		
	}

	@PutMapping("/createcat/{categoryId}")
	public ResponseEntity<CategoryDTO> updateCategory(@RequestBody CategoryDTO categoryDTO,@PathVariable Integer categoryId){
		
		CategoryDTO updatedcat=categoryService.updateUser(categoryDTO, categoryId);
		
		return new ResponseEntity<CategoryDTO>(updatedcat,HttpStatus.OK);
		
	}
	
	@DeleteMapping("/{categoryId}")
	public ResponseEntity<ApiResponse> deleteCategory(@PathVariable Integer categoryId){
		categoryService.deleteUser(categoryId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("category deleted successfully..",true),HttpStatus.OK);
	}
	@GetMapping("/{categoryId}")
	public ResponseEntity<CategoryDTO> getSingleCategory(@PathVariable Integer categoryId){
		CategoryDTO singlecate=	categoryService.getSingleBlogCategory(categoryId);
		return new ResponseEntity<CategoryDTO>(singlecate,HttpStatus.OK);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<CategoryDTO>> getAllCategory(){
		List<CategoryDTO>allcategories=	categoryService.getAllBlogCategory();
		
		return ResponseEntity.ok(allcategories);
	}
}
