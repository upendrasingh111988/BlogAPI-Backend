package com.blog.myblogapi.userRepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.myblogapi.model.Category;
import com.blog.myblogapi.model.Post;
import com.blog.myblogapi.model.User;

public interface PostRepo extends JpaRepository<Post, Integer> {
	
	List<Post> findByUser(User user);
	List<Post> findByCategory(Category category);

}
