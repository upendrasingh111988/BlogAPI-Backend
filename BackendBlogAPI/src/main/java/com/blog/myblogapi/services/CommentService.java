package com.blog.myblogapi.services;

import com.blog.myblogapi.payload.CommentDTO;

public interface CommentService {
	
	CommentDTO createComment(CommentDTO commentDTO, Integer postId);
	
	void deleteComment( Integer commentId);

}
