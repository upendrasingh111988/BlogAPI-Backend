package com.blog.myblogapi.response;

import java.util.List;

import com.blog.myblogapi.payload.PostDTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class PostResponse {
	
	private List<PostDTO> content;
	private int pageNumber;
	private int pageSize;
	private long totalelemets;
	private int totalpages;
	private boolean lastPage;

}
