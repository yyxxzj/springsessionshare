package com.npf.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	
	@RequestMapping("/login")
	public String login(HttpSession session,String username,String password){
		if("zhangsan".equals(username)&&"123456".equals(password)){
			session.setAttribute("username", username);
		}
		return "redirect:/student/find/all";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session){
		session.invalidate();
		return "redirect:/student/find/all";
	}

}