package com.kimino_recipe.desktop.controller;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kimino_recipe.desktop.domain.boardVO;
import com.kimino_recipe.desktop.domain.commentVO;
import com.kimino_recipe.desktop.domain.pageVO;
import com.kimino_recipe.desktop.service.boardService;
import com.kimino_recipe.desktop.service.commentService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class noticeController {
	
	private boardService board;
	private commentService comment;
	
	//게시판 리스트
	@GetMapping("/noticeList")
	public String noticeList(HttpSession session, HttpServletRequest request,
							@RequestParam("board_id") String board_id,
							Model model) {
		
		String url = "notice/notice_List";
		List<boardVO> boardList = new ArrayList<boardVO>();
		
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
	
	//뷰
	@GetMapping("/noticeView")
	public String noticeView(HttpSession session, HttpServletRequest request,
							@RequestParam("board_num")String board_num,
							@RequestParam("board_id")String board_id,
							Model model) {
		
		String url = "notice/notice_View";
		
		/*뒤로가기를 눌렀을 때 이전 페이지를 전달하기 위한 기능*/
		int page = 1;
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
			model.addAttribute("page", page); 
		}
		
		/*검색한 페이지로 들어왔을때 검색한 키워드를 전달하기 위한 기능*/
		String keyWord = null;
		if(request.getParameter("keyWord") != null) {
			keyWord = request.getParameter("keyWord");
			model.addAttribute("keyWord", keyWord);
		}
		
		List<commentVO> commentList = comment.select_Comment(board_num);
		int readCount = board.get_ReadCount(board_num);
		board.update_ReadCount(board_num);
		boardVO boardVO = board.boardView(board_num);
		String writer = board.select_Writer(board_num);
			
		/*줄바꿈*/
		String content = boardVO.getContent();
		content = content.replace("\r\n", "<br>");
		boardVO.setContent(content);
			
		model.addAttribute("commentList", commentList);
		model.addAttribute("readCount", readCount);
		model.addAttribute("boardVO", boardVO);
		model.addAttribute("board_id", board_id);
		model.addAttribute("writer", writer);
			
		/*리다이렉트로 날아온 메세지가 있다면 jsp로 보냄*/
		if(request.getParameter("message") != null) {
			model.addAttribute("message", request.getParameter("message"));
		}
			
	return url;		
	}
	
	//글쓰기 클릭
	@GetMapping("/insert_Notice")
	public String insert_Notice(HttpSession session, HttpServletRequest request,
							@RequestParam("board_id")String board_id,
							Model model) {

		String url = "notice/notice_Write";
		model.addAttribute("board_id", board_id);
		
		return url;		
	}
	
	//글쓰기
	@PostMapping("/inserted_Notice")
	public String inserted_Notice(HttpSession session, HttpServletRequest request,
							@RequestParam("board_id")String board_id,
							boardVO boardVO,
							Model model) {

		String url = "redirect:/noticeList";
		boardVO.setBoard_id(board_id);
		board.insert_Board(boardVO, board_id);
		model.addAttribute("board_id", board_id);
		
		return url;		
	}
	
	
	//게시판 리스트
	@GetMapping("/noticeList_Comment")
	public String noticeList_Comment(HttpSession session, HttpServletRequest request,
							@RequestParam("board_id") String board_id,
							Model model) {
		
		String url = "notice/notice_List";
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
		
		/*리다이렉트로 날아온 메세지가 있다면 jsp로 보냄*/
		if(request.getParameter("message") != null) {
			model.addAttribute("message", request.getParameter("message"));
		}
		
		return url;		
	}
	
	//게시판 리스트
	@GetMapping("/noticeList_ReadCount")
	public String noticeList_ReadCount(HttpSession session, HttpServletRequest request,
							@RequestParam("board_id") String board_id,
							Model model) {
		
		String url = "notice/notice_List";
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
		
		/*리다이렉트로 날아온 메세지가 있다면 jsp로 보냄*/
		if(request.getParameter("message") != null) {
			model.addAttribute("message", request.getParameter("message"));
		}
		
		return url;		
	}
	
	//게시판 리스트
	@GetMapping("/noticeList_Up")
	public String noticeList_Up(HttpSession session, HttpServletRequest request,
							@RequestParam("board_id") String board_id,
							Model model) {
		
		String url = "notice/notice_List";
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
		
		/*리다이렉트로 날아온 메세지가 있다면 jsp로 보냄*/
		if(request.getParameter("message") != null) {
			model.addAttribute("message", request.getParameter("message"));
		}
		
		return url;		
	}
	
	//게시판 리스트
	@GetMapping("/noticeList_Down")
	public String noticeList_Down(HttpSession session, HttpServletRequest request,
							@RequestParam("board_id") String board_id,
							Model model) {
		
		String url = "notice/notice_List";
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
			
		/*리다이렉트로 날아온 메세지가 있다면 jsp로 보냄*/
		if(request.getParameter("message") != null) {
			model.addAttribute("message", request.getParameter("message"));
		}
		
		return url;		
	}
	
}
