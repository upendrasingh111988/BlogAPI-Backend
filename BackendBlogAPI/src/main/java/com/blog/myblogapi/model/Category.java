package com.blog.myblogapi.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="categories")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int categoryId;
	private String categoryTitle;
	private String categoryDescription;
	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Post>posts= new ArrayList<>();
	

}
