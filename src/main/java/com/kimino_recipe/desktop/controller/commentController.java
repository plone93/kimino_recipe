package com.kimino_recipe.desktop.controller;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kimino_recipe.desktop.domain.boardVO;
import com.kimino_recipe.desktop.domain.commentVO;
import com.kimino_recipe.desktop.service.boardService;
import com.kimino_recipe.desktop.service.commentService;
import com.kimino_recipe.desktop.service.loginService;
import com.kimino_recipe.desktop.service.searchService;
import com.kimino_recipe.desktop.service.userService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class commentController {
	
	private loginService login;
	private userService user;
	private boardService board;
	private searchService search;
	private commentService comment;
	
	
	//댓글 작성
	@PostMapping("/insert_Comment")
	public String commentWrite(HttpSession session, HttpServletRequest request,
							  @RequestParam("board_num")String board_num,
							  @RequestParam("board_id")String board_id,
							  @RequestParam("page")String page,
							  commentVO commentVO,
							  Model model) {
		
		String url = "redirect:/boardView";
		int result = 0;
		int commentCount = 0;
		commentVO.setBoard_id(board_id);
		result = comment.insert_Comment(commentVO);
		
		if(result == 1) {
			commentCount = comment.get_CommentCount(board_num); /*해당 글에 몇개의 댓글이 작성됐는지 검색해서  vo에 넣음 */
			comment.update_CommentCount(commentCount, board_num);
			model.addAttribute("message", "댓글 작성 성공");
		} else {
			model.addAttribute("message", "댓글 작성 실패");
		}
		
		model.addAttribute("board_id", board_id);
		model.addAttribute("board_num", board_num);
		model.addAttribute("page", page);
		
		return url;
		
	}
	
	//댓글 수정
	@GetMapping("/edit_Comment")
	public String commentEdit(HttpSession session, HttpServletRequest request,
							  @RequestParam("board_num")String board_num,
							  @RequestParam("board_id")String board_id,
							  @RequestParam("comment_num")String comment_num,
							  @RequestParam("page")String page,
							  Model model) {
		String url = "recipe/recipe_ReWrite_Comment";
		
		int readCount = board.get_ReadCount(board_num);
		board.update_ReadCount(board_num);
		boardVO boardVO = board.boardView(board_num);
		
		model.addAttribute("readCount", readCount);
		model.addAttribute("boardVO", boardVO);
		model.addAttribute("board_id", board_id);

		commentVO commentVO = comment.commentView(comment_num);
		
		model.addAttribute("commentVO", commentVO);
		model.addAttribute("board_num", board_num);
		model.addAttribute("board_id", board_id);
		model.addAttribute("page", page);
		
		return url;
		
	}
	
	//댓글 수정 완료
	@PostMapping("/edited_Comment")
	public String commentEdited(HttpSession session, HttpServletRequest request,
								@RequestParam("board_num")String board_num,
								@RequestParam("board_id")String board_id,
								@RequestParam("comment_num")String comment_num,
								@RequestParam("page")String page,
								commentVO commentVO,
								Model model) {
		
		String url = "redirect:/boardView";
		
		comment.update_Comment(commentVO, comment_num);
		model.addAttribute("board_id", board_id);
		model.addAttribute("board_num", board_num);
		model.addAttribute("page", page);
		
		return url;
		
	}
	
	//댓글 삭제
	@GetMapping("/delete_Comment")
	public String commentDelete(HttpSession session, HttpServletRequest request,
								@RequestParam("board_id")String board_id,
								@RequestParam("board_num")String board_num,
								@RequestParam("comment_num")String comment_num,
								Model model) {
		
		String url = "redirect:/boardView";
		int result = 0;
		int commentCount = 0;
		result = comment.delete_Comment(comment_num);
		
		if(result == 1) {
			commentCount = comment.get_CommentCount(board_num);
			comment.update_CommentCount(commentCount, board_num);
			model.addAttribute("message", "댓글삭제성공");
		} else {
			model.addAttribute("message", "댓글삭제실패");
		}
		
		model.addAttribute("board_id", board_id);
		model.addAttribute("board_num", board_num);
		
		return url;
	}
	
}
