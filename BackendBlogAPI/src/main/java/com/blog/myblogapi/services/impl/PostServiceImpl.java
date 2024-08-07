package com.blog.myblogapi.services.impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.myblogapi.exception.ResourceNotFoundException;
import com.blog.myblogapi.model.Category;
import com.blog.myblogapi.model.Post;
import com.blog.myblogapi.model.User;
import com.blog.myblogapi.payload.PostDTO;
import com.blog.myblogapi.payload.UserDTO;
import com.blog.myblogapi.services.PostService;
import com.blog.myblogapi.userRepo.CategoryRepo;
import com.blog.myblogapi.userRepo.PostRepo;
import com.blog.myblogapi.userRepo.UserRepo;


@Service
public class PostServiceImpl implements PostService {
	
	@Autowired
	private PostRepo postRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private CategoryRepo categoryRepo;

	@Override
	public PostDTO createPost(PostDTO postDTO ,Integer userid , Integer categoryId) {
		User user=userRepo.findById(userid)
				.orElseThrow(()->new ResourceNotFoundException("User", "id", userid));
		
		Category category= categoryRepo.findById(categoryId)
				.orElseThrow(()-> new ResourceNotFoundException("Category", "id", categoryId));
	Post post=	this.modelMapper.map(postDTO, Post.class);
	post.setImageName("default.png");
	post.setAddedDate(new Date());
	post.setUser(user);
	post.setCategory(category);
	Post updatedpost= postRepo.save(post);
	
		return modelMapper.map(updatedpost, PostDTO.class);
	}

	@Override
	public List<Post> getAllPost() {
		
		return null;
	}

	@Override
	public Post getSinglePost(Integer postId) {
		
		return null;
	}

	@Override
	public Post updatePost(PostDTO postDTO, Integer postId) {
		
		return null;
	}

	@Override
	public void deletePost(Integer postId) {
	
		
	}

	@Override
	public List<PostDTO> getPostByCategory(Integer categoryId) {
		Category cate=categoryRepo.findById(categoryId)
				.orElseThrow(()-> new ResourceNotFoundException("category", "id", categoryId));
		
	List<Post>posts=postRepo.findByCategory(cate);
	
	List<PostDTO> postdtos=	posts.stream()
			.map(ecat->this.modelMapper.map(ecat, PostDTO.class)).collect(Collectors.toList());
	
		return postdtos;
	}

	@Override
	public List<PostDTO> getPostByUser(Integer userid) {
		User user= userRepo.findById(userid)
				.orElseThrow(()-> new ResourceNotFoundException("User", "User id", userid));
		System.out.println("User details::"+ user);
		List<Post>posts= postRepo.findByUser(user);
		
		System.out.println("Post details::"+ posts);
		
		List<PostDTO>postdetos=	posts.stream().map(post->this.modelMapper.map(post, PostDTO.class))
				.collect(Collectors.toList());
		
		return postdetos;
	}

	@Override
	public List<Post> searchPosts(String keyword) {
		
		return null;
	}

}
