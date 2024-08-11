package com.blog.myblogapi.payload;

import java.util.HashSet;
import java.util.Set;

import com.blog.myblogapi.model.Role;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
	
	private int userid;
	
	@NotBlank
	@Size(min=4,message="Name must be at four charecter..")
	private String name;
	@Email
	private String email;
	
	private String about;
	@NotBlank
	private String password;
	
	private Set<RoleDTO>roles= new HashSet<>();

}
