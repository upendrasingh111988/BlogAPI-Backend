package com.blog.myblogapi.payload;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentDTO {
	
	private int commentId;
	
	private String content;

}
