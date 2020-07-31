package com.cos.securityex01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.securityex01.model.User;

@Controller
public class IndexController {

   @GetMapping({"","/"})
   public @ResponseBody String index() {
      return "인덱스 페이지입니다.";
   }
   
   @GetMapping("/user")
   public @ResponseBody String user() {
      return "유저 페이지입니다.";
   }
   
   @GetMapping("/admin")
   public @ResponseBody String admin() {
      return "관리자 페이지입니다.";
   }
   
   @GetMapping("/login")
   public String login() {
      return "login";
   }

   @GetMapping("/join")
   public String join() {
	   return "join";
   }
   
   @PostMapping("/joinProc")
   public String joinProc(User user) {
	   System.out.println("회원가입 진행: " + user);
	   return "redirect:/";
   }
   
}