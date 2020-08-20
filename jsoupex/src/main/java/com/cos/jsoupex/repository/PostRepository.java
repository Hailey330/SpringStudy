package com.cos.jsoupex.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cos.jsoupex.model.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
	
}
