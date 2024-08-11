package com.blog.myblogapi.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
public class AuthRequest {
	
	 private String username;
	 private String password;

}
