package com.blog.myblogapi.services.impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.blog.myblogapi.exception.ResourceNotFoundException;
import com.blog.myblogapi.model.Category;
import com.blog.myblogapi.model.Post;
import com.blog.myblogapi.model.User;
import com.blog.myblogapi.payload.PostDTO;
import com.blog.myblogapi.payload.UserDTO;
import com.blog.myblogapi.response.PostResponse;
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
	public PostResponse getAllPost(Integer pageNumber,Integer pageSize, String sortBy,String sortDir) {
		/*
		 * int pageSize=5; int pageNumber=1;
		 */
		/*
		 * Sort sort=null; if(sortDir.equalsIgnoreCase("asc")) { sort=
		 * Sort.by(sortBy).ascending();
		 * 
		 * }else {
		 * 
		 * sort=Sort.by(sortBy).descending(); }
		 */
		Sort sort= (sortDir.equalsIgnoreCase("asc"))?Sort.by(sortBy).ascending():Sort.by(sortBy).descending();
		
		Pageable p= PageRequest.of(pageNumber, pageSize,Sort.by(sortBy).descending());
		
		Page<Post>pagepost=	postRepo.findAll(p);
		List<Post>allposts=pagepost.getContent();
	List<PostDTO>updatedposts=	allposts.stream().map(e->this.modelMapper.map(e, PostDTO.class))
				.collect(Collectors.toList());
	PostResponse postResponse= new PostResponse();
	postResponse.setContent(updatedposts);
	postResponse.setPageNumber(pagepost.getNumber());
	postResponse.setPageSize(pagepost.getSize());
	postResponse.setTotalelemets(pagepost.getNumberOfElements());
	postResponse.setTotalpages(pagepost.getTotalPages());
	postResponse.setLastPage(pagepost.isLast());
	
		return postResponse;
	}

	@Override
	public PostDTO getSinglePost(Integer postId) {
		Post pos=postRepo.findById(postId)
				.orElseThrow(()-> new ResourceNotFoundException("Post", "Post Id", postId));
	PostDTO postdtos=	this.modelMapper.map(pos, PostDTO.class);
		return postdtos ;
	}

	@Override
	public PostDTO updatePost(PostDTO postDTO, Integer postId) {
		
		Post postfetchingfromdb=postRepo.findById(postId)
				.orElseThrow(()-> new ResourceNotFoundException("Post", "id", postId));
		postfetchingfromdb.setPostTitle(postDTO.getPostTitle());
		postfetchingfromdb.setContent(postDTO.getContent());
		postfetchingfromdb.setImageName(postDTO.getImageName());
		//postfetchingfromdb.setAddedDate(postDTO.getAddedDate());
		Post updateddatainDb=	postRepo.save(postfetchingfromdb);
	
		PostDTO pos = this.modelMapper.map(updateddatainDb, PostDTO.class);
		
		
		return pos;
	}

	@Override
	public void deletePost(Integer postId) {
		Post postfetchingbyparticularid	=postRepo.findById(postId)
					.orElseThrow(()-> new ResourceNotFoundException("Post", "id", postId));
		postRepo.delete(postfetchingbyparticularid);
		
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
	public List<PostDTO> searchPosts(String keyword) {
		List<Post> findByPostTitleContaining = postRepo.findByPostTitleContaining(keyword);
		
		//PostDTO postdtos = this.modelMapper.map(findByPostTitleContaining, PostDTO.class);
		
		List<PostDTO> postdtos = findByPostTitleContaining.stream().map(k->this.modelMapper.map(k, PostDTO.class))
		.collect(Collectors.toList());
		
		return postdtos;
	}

}
