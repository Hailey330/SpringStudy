package com.cos.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

// Controller - 사용자가 request할 때 메모리에 뜸
@Controller
public class IndexController {

	@Autowired
	Test t;

	// http://localhost:8080/
	@GetMapping({ "", "/" })
	public @ResponseBody String index() {
		System.out.println(t.num);
		return "Hello"; // ViewResolver
	}

	// x-www-form-urlencoded → Key=Value
	@PostMapping("/form/model")
	public @ResponseBody String formModel(String username, String password, String email) {
		System.out.println(username);
		System.out.println(password);
		System.out.println(email);
		return "User"; // ViewResolver
	}

	// x-www-form-urlencoded → Key=Value
	@GetMapping("/form/model")
	public @ResponseBody String formModelGet(User user) {
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		System.out.println(user.getEmail());
		return "User"; // ViewResolver
	}

	// json → {"Key" : Value}
	@PostMapping("/json/model")
	public @ResponseBody User jsonModel(@RequestBody User user) {
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		System.out.println(user.getEmail());
		return user; // ViewResolver 작동금지 → jackson 작동 
	}
}
