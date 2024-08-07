package com.blog.myblogapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.myblogapi.payload.PostDTO;
import com.blog.myblogapi.services.PostService;

@RestController
@RequestMapping("/api/")
public class PostController {
	
	@Autowired
	private PostService postService;
	
	@PostMapping("/user/{userid}/category/{categoryId}/posts")
	public ResponseEntity<PostDTO> createPost(
			@RequestBody PostDTO postDTO,
			@PathVariable Integer userid,
			@PathVariable Integer categoryId
			
			
			){
		
	PostDTO postDTO2=postService.createPost(postDTO, userid, categoryId);
	
	return new ResponseEntity<PostDTO>(postDTO2, HttpStatus.CREATED);
	}
	// get bu user
	@GetMapping("users/{userid}/posts")
	public ResponseEntity<List<PostDTO>> getpostsByUser(@PathVariable Integer userid){
		
		List<PostDTO>posts=postService.getPostByUser(userid);
		
		return new ResponseEntity<List<PostDTO>>(posts,HttpStatus.OK);
	}
	
	// get bu category
		@GetMapping("category/{categoryId}/posts")
		public ResponseEntity<List<PostDTO>> getpostsByCategory(@PathVariable Integer categoryId){
			
			List<PostDTO>posts=postService.getPostByCategory(categoryId);
			
			return new ResponseEntity<List<PostDTO>>(posts,HttpStatus.OK);
		}

}
