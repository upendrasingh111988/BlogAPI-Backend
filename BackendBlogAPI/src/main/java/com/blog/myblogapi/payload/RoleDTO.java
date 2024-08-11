package com.blog.myblogapi.payload;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class RoleDTO {

	private int roleId;
	private String name;
}
