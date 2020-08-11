package com.cos.validex01.test;

import javax.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.validex01.ProjectTask;

@RestController
public class BindControllerTest {
	
	@GetMapping("/test/before")
	public void testBefore(@Valid @RequestBody ProjectTask pp, BindingResult result) {
		System.out.println("testBefore 실행됨");
	}

}
