package com.kimino_recipe.desktop.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kimino_recipe.desktop.domain.boardVO;
import com.kimino_recipe.desktop.service.boardService;
import com.kimino_recipe.desktop.service.loginService;
import com.kimino_recipe.desktop.service.userService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class mainController {
	
	private static final Logger logger = LoggerFactory.getLogger(mainController.class);
	private loginService login;
	private userService user;
	private boardService board;
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		String url = "redirect:/main";
		return url;
	}
	
	@GetMapping("/main")
	public String main(HttpSession session, HttpServletRequest request, Model model) {
		String url = "index";
		
		int page = 1;
		if(request.getParameter("page") != null){
			page = Integer.parseInt(request.getParameter("page"));
		}
		
		List<boardVO> boardList_Season_Up = new ArrayList<boardVO>();
		String board_id1 = "봄";
		String board_id2 = "여름";
		String board_id3 = "가을";
		String board_id4 = "겨울";
		boardList_Season_Up = board.select_Season_Up(page, board_id1, board_id2, board_id3, board_id4);
		model.addAttribute("season", boardList_Season_Up);
		
		List<boardVO> boardList_Country_Up = new ArrayList<boardVO>();
		String board_id11 = "한국요리";
		String board_id22 = "일본요리";
		String board_id33 = "서양요리";
		boardList_Country_Up = board.select_Country_Up(page, board_id11, board_id22, board_id33);
		model.addAttribute("country", boardList_Country_Up);
		
		List<boardVO> boardList_Single = new ArrayList<boardVO>();
		String board_id111 = "자취";
		boardList_Single = board.select_Single_Up(page, board_id111);
		model.addAttribute("single", boardList_Single);
		
		/*리다이렉트로 날아온 메세지가 있다면 jsp로 보냄*/
		if(request.getParameter("message") != null) {
			model.addAttribute("message", request.getParameter("message"));
		}
		
		return url;
	}

}
