package com.cos.reactprops;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {

	@Autowired
	private PostRepository repo;

	@CrossOrigin 
	// @CrossOrigin : CORS 정책 안걸리게 해준다. 
	@GetMapping("/post")
	public List<Post> getPosts() {
		return repo.findAll(); // java Object → jackson 발동하면서 json 데이터로 변환
	}

}
