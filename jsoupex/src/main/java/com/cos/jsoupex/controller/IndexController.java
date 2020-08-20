package com.cos.jsoupex.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.jsoupex.model.Post;
import com.cos.jsoupex.repository.PostRepository;
import com.cos.jsoupex.service.NowService;

import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin(origins = "/*")
@RequestMapping("brunch") // 컨트롤러 진입 주소
@RequiredArgsConstructor // final과 붙어있는 필드의 생성자를 다 만들어줌

public class IndexController {

	private final PostRepository postRepository;

	@GetMapping("home")
	public String home() {
		return "연결 성공";
	}

	@PostMapping("post")
	public String post(@RequestBody Post post) {
		postRepository.save(post);
		return "글쓰기 완료";
	}


	@GetMapping("/posts")
	public List<Post> getPosts() {
		return postRepository.findAll();
	}
	
	@GetMapping("/postlist")
	public String save(NowService nowService) throws IOException {
		List<Post> postList = nowService.getBrunchDatas();
		postRepository.saveAll(postList);
		return "크롤링 데이터 삽입 완료";
	}
	
}
