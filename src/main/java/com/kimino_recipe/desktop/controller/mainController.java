package com.kimino_recipe.desktop.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.kimino_recipe.desktop.service.boardService;
import com.kimino_recipe.desktop.service.loginService;
import com.kimino_recipe.desktop.service.userService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class mainController {
	
	private loginService login;
	private userService user;
	private boardService board;
	
	@GetMapping("/main")
	public String main(HttpSession session, HttpServletRequest request, Model model) {
		String url = "index";
		
		/*리다이렉트로 날아온 메세지가 있다면 jsp로 보냄*/
		if(request.getParameter("message") != null) {
			model.addAttribute("message", request.getParameter("message"));
		}
		
		return url;
	}

}
