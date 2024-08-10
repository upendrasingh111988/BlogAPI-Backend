package com.blog.myblogapi.payload;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.blog.myblogapi.model.Category;
import com.blog.myblogapi.model.Comment;
import com.blog.myblogapi.model.User;

import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor

public class PostDTO {

	private int postId;
	
	private String postTitle;
	
	private String content;
	
	private String imageName;
	
	private Date addedDate;
	
	private CategoryDTO category;
	
	private UserDTO user;
	
	private Set<CommentDTO>comments= new HashSet<>();
	
	
}
