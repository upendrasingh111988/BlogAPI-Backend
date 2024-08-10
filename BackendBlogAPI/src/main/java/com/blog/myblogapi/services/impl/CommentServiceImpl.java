package com.blog.myblogapi.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.myblogapi.exception.ResourceNotFoundException;
import com.blog.myblogapi.model.Comment;
import com.blog.myblogapi.model.Post;
import com.blog.myblogapi.payload.CommentDTO;
import com.blog.myblogapi.services.CommentService;
import com.blog.myblogapi.userRepo.CommentRepo;
import com.blog.myblogapi.userRepo.PostRepo;

@Service
public class CommentServiceImpl implements CommentService {
	
	@Autowired
	private PostRepo postRepo;
	
	@Autowired
	private CommentRepo commentRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CommentDTO createComment(CommentDTO commentDTO, Integer postId) {
		Post post= postRepo.findById(postId)
				.orElseThrow(()-> new ResourceNotFoundException("Post", "id", postId));
		
		Comment comment=modelMapper.map(commentDTO, Comment.class);
		
		comment.setPost(post);
		
		Comment savedComments = commentRepo.save(comment);
		
		return modelMapper.map(savedComments, CommentDTO.class);
	}

	@Override
	public void deleteComment(Integer commentId) {

		Comment comment=commentRepo.findById(commentId)
					.orElseThrow(()-> new ResourceNotFoundException("comment", "id", commentId));
		commentRepo.delete(comment);
	}

}
