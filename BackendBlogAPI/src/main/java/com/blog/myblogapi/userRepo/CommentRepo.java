package com.blog.myblogapi.userRepo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.myblogapi.model.Comment;

public interface CommentRepo  extends JpaRepository<Comment, Integer>{

}
