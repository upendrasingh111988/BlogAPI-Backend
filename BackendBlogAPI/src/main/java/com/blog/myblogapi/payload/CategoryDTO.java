package com.blog.myblogapi.payload;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CategoryDTO {
	
	private int categoryId;
	@NotBlank
	@Size(min=4,message="title must be 4 charecter")
	private String categoryTitle;
	
	private String categoryDescription;
}
