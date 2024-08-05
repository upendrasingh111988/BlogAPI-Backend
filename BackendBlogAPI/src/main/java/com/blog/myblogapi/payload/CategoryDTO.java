package com.blog.myblogapi.payload;

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
	private String categoryTitle;
	private String categoryDescription;
}
