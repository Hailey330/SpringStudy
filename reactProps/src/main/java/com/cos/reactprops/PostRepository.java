package com.cos.reactprops;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

// DB에서 들고온 데이터라고 가정
@Repository
public class PostRepository {

	public static List<Post> findAll() {
		List<Post> posts = new ArrayList<Post>();
		for (int i = 1; i < 11; i++) {
			Post p = new Post(i, "제목" + i, "내용" + i);
			posts.add(p);
		}
		return posts;
	}
}
