package com.kimino_recipe.desktop.controller;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kimino_recipe.desktop.domain.boardVO;
import com.kimino_recipe.desktop.domain.commentVO;
import com.kimino_recipe.desktop.domain.countVO;
import com.kimino_recipe.desktop.domain.pageVO;
import com.kimino_recipe.desktop.domain.userVO;
import com.kimino_recipe.desktop.service.boardService;
import com.kimino_recipe.desktop.service.commentService;
import com.kimino_recipe.desktop.service.loginService;
import com.kimino_recipe.desktop.service.searchService;
import com.kimino_recipe.desktop.service.userService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class boardController2 {
	
	private loginService login;
	private userService user;
	private boardService board;
	private searchService search;
	private commentService comment;
	
	
	//게시판 리스트
	@GetMapping("/boardList2")
	public String boardList2(HttpSession session, HttpServletRequest request,
							@RequestParam("board_id") String board_id,
							Model model) {
		
		String url = "board/board_List";
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
			boardList = board.select_AllBoard_Up(page, board_id, hotcount);
			pageVO.setTotalCount(board.get_BoardCount_Up(board_id, hotcount));
			boardCount = pageVO.getTotalCount();
		} else if(board_id.equals("비추천")) {
			word = "down";
			boardList = board.select_AllBoard_Down(page, board_id, hotcount);
			pageVO.setTotalCount(board.get_BoardCount_Down(board_id, hotcount));
			boardCount = pageVO.getTotalCount();
		} else if(board_id.equals("통합")) {
			boardList = board.select_AllBoard_Total(page, board_id);
			pageVO.setTotalCount(board.get_BoardCount_Total(board_id));
			boardCount = pageVO.getTotalCount();
		} else if(board_id.equals("회원관리")) {
			userList = board.select_AllBoard_User(page);
			pageVO.setTotalCount(board.get_UserCount());
			boardCount = pageVO.getTotalCount();
			url = "";
		} else {
			boardList = board.select_AllBoard(page, board_id);
			pageVO.setTotalCount(board.get_BoardCount(board_id));
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
	
	//글쓰기 클릭
	@GetMapping("/insert_Board2")
	public String insert_Board2(HttpSession session, HttpServletRequest request,
							@RequestParam("board_id")String board_id,
							Model model) {

		String url = "board/board_Write";
		model.addAttribute("board_id", board_id);
		
		return url;		
	}
	
	//글쓰기
	@PostMapping("/inserted_Board2")
	public String inserted_Board2(HttpSession session, HttpServletRequest request,
							@RequestParam("board_id")String board_id,
							boardVO boardVO,
							Model model) {

		String url = "redirect:/boardList2";
		boardVO.setBoard_id(board_id);
		board.insert_Board(boardVO, board_id);
		model.addAttribute("board_id", board_id);
		
		return url;		
	}

	//게시판 리스트
	@GetMapping("/boardList_Comment2")
	public String boardList_Comment2(HttpSession session, HttpServletRequest request,
							@RequestParam("board_id") String board_id,
							Model model) {
		
		String url = "board/board_List";
		List<boardVO> boardList = new ArrayList<boardVO>();
		
		int page = 1;
		int boardCount = 0;
		
		if(request.getParameter("page") != null){
			page = Integer.parseInt(request.getParameter("page"));
		}
		pageVO pageVO = new pageVO();
		pageVO.setPage(page);
		

		boardList = board.select_Board_Comment(page, board_id);
		pageVO.setTotalCount(board.get_BoardCount(board_id));
		boardCount = pageVO.getTotalCount();
		
		
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
	
	//게시판 리스트
	@GetMapping("/boardList_ReadCount2")
	public String boardList_ReadCount2(HttpSession session, HttpServletRequest request,
							@RequestParam("board_id") String board_id,
							Model model) {
		
		String url = "board/board_List";
		List<boardVO> boardList = new ArrayList<boardVO>();
		
		int page = 1;
		int boardCount = 0;
		
		if(request.getParameter("page") != null){
			page = Integer.parseInt(request.getParameter("page"));
		}
		pageVO pageVO = new pageVO();
		pageVO.setPage(page);
		

		boardList = board.select_Board_ReadCount(page, board_id);
		pageVO.setTotalCount(board.get_BoardCount(board_id));
		boardCount = pageVO.getTotalCount();
		
		
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
	
	//게시판 리스트
	@GetMapping("/boardList_Up2")
	public String boardList_Up2(HttpSession session, HttpServletRequest request,
							@RequestParam("board_id") String board_id,
							Model model) {
		
		String url = "board/board_List";
		List<boardVO> boardList = new ArrayList<boardVO>();

		int page = 1;
		int boardCount = 0;

		if(request.getParameter("page") != null){
			page = Integer.parseInt(request.getParameter("page"));
		}
		pageVO pageVO = new pageVO();
		pageVO.setPage(page);
		

		boardList = board.select_Board_Up(page, board_id);
		pageVO.setTotalCount(board.get_BoardCount(board_id));
		boardCount = pageVO.getTotalCount();
		
		
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
	
	//게시판 리스트
	@GetMapping("/boardList_Down2")
	public String boardList_Down2(HttpSession session, HttpServletRequest request,
							@RequestParam("board_id") String board_id,
							Model model) {
		
		String url = "board/board_List";
		List<boardVO> boardList = new ArrayList<boardVO>();
		
		int page = 1;
		int boardCount = 0;

		if(request.getParameter("page") != null){
			page = Integer.parseInt(request.getParameter("page"));
		}
		pageVO pageVO = new pageVO();
		pageVO.setPage(page);
		

		boardList = board.select_Board_Down(page, board_id);
		pageVO.setTotalCount(board.get_BoardCount(board_id));
		boardCount = pageVO.getTotalCount();
		
		
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

	
}
