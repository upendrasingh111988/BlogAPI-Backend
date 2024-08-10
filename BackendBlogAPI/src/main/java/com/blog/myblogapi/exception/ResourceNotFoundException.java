package com.blog.myblogapi.exception;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

@Data
public class ResourceNotFoundException extends RuntimeException {
	String resourceName;
	String fieldName;
	long fieldValue;
	String email;
	public ResourceNotFoundException(String resourceName, String fieldName, long fieldValue) {
		super(String.format("%s Resource Not Sound %s" , resourceName,fieldName,fieldValue));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}
	
	/*
	 * public ResourceNotFoundException(String resourceName, String fieldName,
	 * String email) { super(String.format("%s Resource Not Sound %s" ,
	 * resourceName,fieldName,email)); this.resourceName = resourceName;
	 * this.fieldName = fieldName; this.email = email; }
	 */
}
