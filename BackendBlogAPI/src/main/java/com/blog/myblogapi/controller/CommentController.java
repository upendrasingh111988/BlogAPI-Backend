package com.blog.myblogapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.myblogapi.model.Comment;
import com.blog.myblogapi.payload.CommentDTO;
import com.blog.myblogapi.response.ApiResponse;
import com.blog.myblogapi.services.CommentService;
import com.blog.myblogapi.userRepo.CommentRepo;

@RestController
@RequestMapping("/api/")
public class CommentController {
	@Autowired
	private CommentService commentService;
	
	@PostMapping("post/{postId}/comments")
	public ResponseEntity<CommentDTO> createComment(
			@RequestBody CommentDTO commentDTO ,
			@PathVariable Integer postId
			){
		
		CommentDTO createComment = commentService.createComment(commentDTO, postId);
		
		return new ResponseEntity<CommentDTO>(createComment,HttpStatus.CREATED);
	}
	
	@DeleteMapping("comments/{commentId}")
	public ResponseEntity<ApiResponse> deleteComment(@PathVariable Integer commentId){
		
		commentService.deleteComment(commentId);
		
		return new ResponseEntity<ApiResponse>( new ApiResponse("deleted successfully",true),HttpStatus.OK);
		
	}
}
