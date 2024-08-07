package com.blog.myblogapi.payload;

import java.util.Date;

import com.blog.myblogapi.model.Category;
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
	
	
}
