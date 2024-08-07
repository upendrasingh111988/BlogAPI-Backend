package com.blog.myblogapi.services;

import java.util.List;

import com.blog.myblogapi.model.Post;
import com.blog.myblogapi.payload.PostDTO;

public interface PostService {
	
	PostDTO createPost(PostDTO postDTO, Integer userid , Integer categoryId);
	
	List<Post> getAllPost();
	
	Post getSinglePost(Integer postId);

	Post updatePost(PostDTO postDTO , Integer postId);
	
	void deletePost(Integer postId);
	
	List<PostDTO> getPostByCategory(Integer categoryId);
	
	List<PostDTO> getPostByUser(Integer userid);
	
	List<Post> searchPosts(String keyword);
}
