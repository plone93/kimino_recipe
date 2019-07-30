package com.kimino_recipe.desktop.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kimino_recipe.desktop.domain.boardVO;
import com.kimino_recipe.desktop.domain.pageVO;
import com.kimino_recipe.desktop.domain.searchVO;
import com.kimino_recipe.desktop.domain.userVO;
import com.kimino_recipe.desktop.service.boardService;
import com.kimino_recipe.desktop.service.commentService;
import com.kimino_recipe.desktop.service.loginService;
import com.kimino_recipe.desktop.service.searchService;
import com.kimino_recipe.desktop.service.userService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class searchController {
	
	private loginService login;
	private userService user;
	private boardService board;
	private searchService search;
	private commentService comment;

	
	//검색
	@PostMapping("/search_Board")
	public String search_Board(HttpSession session, HttpServletRequest request,
							  @RequestParam("board_id")String board_id,
							  searchVO searchVO,
							  Model model) {
		
		String url = "recipe/recipe_List";
		System.out.println("검색한 키워드 : "+searchVO.getKeyword());
		
		List<boardVO> boardList = new ArrayList<boardVO>();
		List<userVO> userList = new ArrayList<userVO>();
		
		int page = 1;
		int boardCount = 0;
		String hotcount = "5"; // 추천,비추천 게시판에 올라가기 위한  조건
		String word;
		
		
		if(request.getParameter("page") != null){
			page = Integer.parseInt(request.getParameter("page"));
		}
		pageVO pageVO = new pageVO();
		pageVO.setPage(page);
		
		if(board_id.equals("추천")) {
			word = "up";
			boardList = search.search_Up(page, searchVO, hotcount);
			pageVO.setTotalCount(search.search_Count_Up(searchVO, hotcount));
			boardCount = pageVO.getTotalCount();
		} else if(board_id.equals("비추천")) {
			word = "down";
			boardList = search.search_Down(page, searchVO, hotcount);
			pageVO.setTotalCount(search.search_Count_Down(searchVO, hotcount));
			boardCount = pageVO.getTotalCount();
		} else if(board_id.equals("통합")) {
			boardList = search.search_Total(page, searchVO);
			pageVO.setTotalCount(search.search_Count_Total(searchVO));
			boardCount = pageVO.getTotalCount();
		} else if(board_id.equals("신고")) {
			word = "report";
			boardList = search.search_Report(page, searchVO);
			pageVO.setTotalCount(search.search_Count_Report(searchVO));
			boardCount = pageVO.getTotalCount();
		} else if(board_id.equals("회원관리")) {
			userList = search.search_User(page, searchVO);
			pageVO.setTotalCount(search.search_Count_User(searchVO));
			boardCount = pageVO.getTotalCount();
			url = "";
		} else {
			boardList = search.search(page, searchVO, board_id);
			pageVO.setTotalCount(search.search_Count(searchVO, board_id));
			boardCount = pageVO.getTotalCount();
		}
		
		model.addAttribute("boardList", boardList);
		model.addAttribute("boardCount", boardCount);
		model.addAttribute("pageVO", pageVO);
		model.addAttribute("board_id", board_id);
		
		/*일반게시판 공지사항*/
		String noticeBoard_id = "공지사항";
		List<boardVO> noticeList = board.select_AllBoard_Notice(page, noticeBoard_id);
		model.addAttribute("noticeList", noticeList);
		
		/*리다이렉트로 날아온 메세지가 있다면 jsp로 보냄*/
		if(request.getParameter("message") != null) {
			model.addAttribute("message", request.getParameter("message"));
		}
		
		return url;		
	}
	
	//검색
	@PostMapping("/search_Board2")
	public String search_Board2(HttpSession session, HttpServletRequest request,
							  @RequestParam("board_id")String board_id,
							  searchVO searchVO,
							  Model model) {
		
		String url = "board/board_List";
		System.out.println("검색한 키워드 : "+searchVO.getKeyword());
		
		List<boardVO> boardList = new ArrayList<boardVO>();
		List<userVO> userList = new ArrayList<userVO>();
		
		int page = 1;
		int boardCount = 0;
		String hotcount = "5"; // 추천,비추천 게시판에 올라가기 위한  조건
		String word;
		
		
		if(request.getParameter("page") != null){
			page = Integer.parseInt(request.getParameter("page"));
		}
		pageVO pageVO = new pageVO();
		pageVO.setPage(page);
		
		if(board_id.equals("추천")) {
			word = "up";
			boardList = search.search_Up(page, searchVO, hotcount);
			pageVO.setTotalCount(search.search_Count_Up(searchVO, hotcount));
			boardCount = pageVO.getTotalCount();
		} else if(board_id.equals("비추천")) {
			word = "down";
			boardList = search.search_Down(page, searchVO, hotcount);
			pageVO.setTotalCount(search.search_Count_Down(searchVO, hotcount));
			boardCount = pageVO.getTotalCount();
		} else if(board_id.equals("통합")) {
			boardList = search.search_Total(page, searchVO);
			pageVO.setTotalCount(search.search_Count_Total(searchVO));
			boardCount = pageVO.getTotalCount();
		} else if(board_id.equals("신고")) {
			word = "report";
			boardList = search.search_Report(page, searchVO);
			pageVO.setTotalCount(search.search_Count_Report(searchVO));
			boardCount = pageVO.getTotalCount();
		} else if(board_id.equals("회원관리")) {
			userList = search.search_User(page, searchVO);
			pageVO.setTotalCount(search.search_Count_User(searchVO));
			boardCount = pageVO.getTotalCount();
			url = "";
		} else {
			boardList = search.search(page, searchVO, board_id);
			pageVO.setTotalCount(search.search_Count(searchVO, board_id));
			boardCount = pageVO.getTotalCount();
		}
		
		model.addAttribute("boardList", boardList);
		model.addAttribute("boardCount", boardCount);
		model.addAttribute("pageVO", pageVO);
		model.addAttribute("board_id", board_id);
		
		/*일반게시판 공지사항*/
		String noticeBoard_id = "공지사항";
		List<boardVO> noticeList = board.select_AllBoard_Notice(page, noticeBoard_id);
		model.addAttribute("noticeList", noticeList);
		
		/*리다이렉트로 날아온 메세지가 있다면 jsp로 보냄*/
		if(request.getParameter("message") != null) {
			model.addAttribute("message", request.getParameter("message"));
		}
		
		return url;		
	}
	
	
	//검색
	@PostMapping("/search_Board_Total")
	public String search_Board_Total(HttpSession session, HttpServletRequest request,
									  searchVO searchVO,
									  Model model) {
		
		String url = "board/board_List";
		System.out.println("검색한 키워드 : "+searchVO.getKeyword());
		
		List<boardVO> boardList = new ArrayList<boardVO>();
		
		int page = 1;
		int boardCount = 0;

		if(request.getParameter("page") != null){
			page = Integer.parseInt(request.getParameter("page"));
		}
		pageVO pageVO = new pageVO();
		pageVO.setPage(page);

		boardList = search.search_Total(page, searchVO);
		pageVO.setTotalCount(search.search_Count_Total(searchVO));
		boardCount = pageVO.getTotalCount();
	
		model.addAttribute("boardList", boardList);
		model.addAttribute("boardCount", boardCount);
		model.addAttribute("pageVO", pageVO);
		
		/*일반게시판 공지사항*/
		String noticeBoard_id = "공지사항";
		List<boardVO> noticeList = board.select_AllBoard_Notice(page, noticeBoard_id);
		model.addAttribute("noticeList", noticeList);
		
		/*리다이렉트로 날아온 메세지가 있다면 jsp로 보냄*/
		if(request.getParameter("message") != null) {
			model.addAttribute("message", request.getParameter("message"));
		}
		
		return url;		
	}
	
	//관리자게시판의 유저관리 게시판 검색
	@PostMapping("/search_Board_User")
	public String search_Board_User(HttpSession session, HttpServletRequest request,
									  searchVO searchVO,
									  Model model) {
		
		String url = "myPage/userList";
		System.out.println("검색한 키워드 : "+searchVO.getKeyword());
		
		List<userVO> userList = new ArrayList<userVO>();
		
		int page = 1;
		int boardCount = 0;

		if(request.getParameter("page") != null){
			page = Integer.parseInt(request.getParameter("page"));
		}
		pageVO pageVO = new pageVO();
		pageVO.setPage(page);

		userList = search.search_User(page, searchVO);
		pageVO.setTotalCount(search.search_Count_User(searchVO));
		boardCount = pageVO.getTotalCount();
	
		model.addAttribute("userList", userList);
		model.addAttribute("boardCount", boardCount);
		model.addAttribute("pageVO", pageVO);
		
		/*일반게시판 공지사항*/
		String noticeBoard_id = "공지사항";
		List<boardVO> noticeList = board.select_AllBoard_Notice(page, noticeBoard_id);
		model.addAttribute("noticeList", noticeList);
		
		/*리다이렉트로 날아온 메세지가 있다면 jsp로 보냄*/
		if(request.getParameter("message") != null) {
			model.addAttribute("message", request.getParameter("message"));
		}
		
		return url;		
	}
	
	
	//관리자 게시판의 신고 게시판 검색
	@PostMapping("/search_Board_Report")
	public String search_Board_Report(HttpSession session, HttpServletRequest request,
									  searchVO searchVO,
									  Model model) {
		
		String url = "myPage/reportList";
		System.out.println("검색한 키워드 : "+searchVO.getKeyword());
		
		List<boardVO> boardList = new ArrayList<boardVO>();
		
		int page = 1;
		int boardCount = 0;

		if(request.getParameter("page") != null){
			page = Integer.parseInt(request.getParameter("page"));
		}
		pageVO pageVO = new pageVO();
		pageVO.setPage(page);

		boardList = search.search_Report(page, searchVO);
		pageVO.setTotalCount(search.search_Count_Report(searchVO));
		boardCount = pageVO.getTotalCount();
	
		model.addAttribute("boardList", boardList);
		model.addAttribute("boardCount", boardCount);
		model.addAttribute("pageVO", pageVO);
		
		/*일반게시판 공지사항*/
		String noticeBoard_id = "공지사항";
		List<boardVO> noticeList = board.select_AllBoard_Notice(page, noticeBoard_id);
		model.addAttribute("noticeList", noticeList);
		
		/*리다이렉트로 날아온 메세지가 있다면 jsp로 보냄*/
		if(request.getParameter("message") != null) {
			model.addAttribute("message", request.getParameter("message"));
		}
		
		return url;		
	}
	
}
