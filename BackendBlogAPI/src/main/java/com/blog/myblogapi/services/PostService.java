package com.blog.myblogapi.services;

import java.util.List;

import com.blog.myblogapi.model.Post;
import com.blog.myblogapi.payload.PostDTO;
import com.blog.myblogapi.response.PostResponse;

public interface PostService {
	
	PostDTO createPost(PostDTO postDTO, Integer userid , Integer categoryId);
	
	PostResponse getAllPost(Integer pageNumber,Integer pageSize, String sortBy,String sortDir);
	
	PostDTO getSinglePost(Integer postId);

	PostDTO updatePost(PostDTO postDTO , Integer postId);
	
	void deletePost(Integer postId);
	
	List<PostDTO> getPostByCategory(Integer categoryId);
	
	List<PostDTO> getPostByUser(Integer userid);
	
	List<Post> searchPosts(String keyword);
}
