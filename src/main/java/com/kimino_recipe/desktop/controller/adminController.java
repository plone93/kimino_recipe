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
import org.springframework.web.bind.annotation.ResponseBody;

import com.kimino_recipe.desktop.domain.adminVO;
import com.kimino_recipe.desktop.domain.boardVO;
import com.kimino_recipe.desktop.domain.commentVO;
import com.kimino_recipe.desktop.domain.pageVO;
import com.kimino_recipe.desktop.domain.userVO;
import com.kimino_recipe.desktop.service.boardService;
import com.kimino_recipe.desktop.service.commentService;
import com.kimino_recipe.desktop.service.loginService;
import com.kimino_recipe.desktop.service.userService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class adminController {
	
	private loginService login;
	private userService user;
	private boardService board;
	private commentService comment;
	

	//관리자 로그인 버튼
	@GetMapping("/login_Admin")
	public String adminLogin(HttpSession session, HttpServletRequest request) {
		String url ="login/login_Admin";
		return url;		
	}
	
	//관리자 로그인 완료
	@PostMapping("/Logined_Admin")
	public String adminLogined(HttpSession session, HttpServletRequest request,
							  @RequestParam("admin_id")String admin_id,
							  @RequestParam("admin_pass")String admin_pass,
							  Model model) {

		String url = "redirect:/main";
		int result = 0;
				
		result = login.login_Admin(admin_id, admin_pass);
				
		if(result >= 1) { /*결과 값이 1이라면 로그인에 성공*/
			adminVO adminVO = user.get_Admin(admin_id);
			session = request.getSession();
			session.setAttribute("loginAdmin", adminVO);
			model.addAttribute("message", "로그인 성공");
		} else if(result == 0) {
			model.addAttribute("message", "아이디나 비밀번호 확인해주셈");
		}
				
		return url;	
	}
	
	//관리페이지
	@GetMapping("/admin_Page")
	public String admin_Page(@RequestParam("admin_id")String admin_id,
							 Model model) {
		String url = "myPage/admin_Page";
		
		adminVO adminVO = user.get_Admin(admin_id);
		
		model.addAttribute("adminVO", adminVO);
		return url;
	}
	
	//이메일 갱신
	@ResponseBody
	@PostMapping("/emailUpdate_Admin")
	public int emailUpdate_Admin(HttpSession session, HttpServletRequest request,
					   @RequestParam("admin_email")String admin_email,
					   @RequestParam("admin_num")String admin_num,
					   Model model) {
		
		int emailCheck = 0; // 초기화
		int result = 0; //jsp에서 ajax를 통해 결과를 알려줄 변수
		emailCheck = user.emailCheck_Admin(admin_email); //중복 체크
		
		
		if(emailCheck >= 1) {
			result = 1; /* 1이면 중복된 이메일 검색되서 1이상이 리턴됐으므로 사용불가, 검색된 행의 갯수를 리턴함 */
			model.addAttribute("result", result);	
		} else if(emailCheck == 0){ // 중복이 없음
			user.emailUpdate_Admin(admin_num, admin_email); //이메일 변경
			model.addAttribute("result", result);	
		}
		
		return result;		
	}
	
	//닉네임 갱신
	@ResponseBody
	@PostMapping("/nameUpdate_Admin")
	public int nameUpdate_Admin(HttpSession session, HttpServletRequest request,
					   @RequestParam("admin_name")String admin_name,
					   @RequestParam("admin_num")String admin_num,
					   Model model) {
		
		int nameCheck = 0;
		int result = 0; //jsp에서 ajax를 통해 결과를 알려줄 변수
		nameCheck = user.nameCheck(admin_name);
		
		if(nameCheck >= 1) {
			result = 1; /* 1이면 중복된 아이디가 검색되서 1이 리턴됐으므로 사용불가, 검색된 행의 갯수를 리턴함 */
			model.addAttribute("result", result);	
		} else if(nameCheck == 0){
			user.nameUpdate_Admin(admin_num, admin_name); //닉네임 변경
			model.addAttribute("result", result);	
		}
		
		return result;		
	}
	
	
	//비밀번호 갱신
	@ResponseBody
	@PostMapping("/passUpdate_Admin")
	public int passUpdate_Admin(HttpSession session, HttpServletRequest request,
					   @RequestParam("admin_pass")String admin_pass,
					   @RequestParam("admin_num")String admin_num,
					   Model model) {
		
		int result = 0; //jsp에서 ajax를 통해 결과를 알려줄 변수
		
		result = user.passUpdate_Admin(admin_num, admin_pass);
		model.addAttribute("result", result);
		
		return result;		
	}
	
	
	//관리페이지의 회원관리 게시판
	@GetMapping("/userList")
	public String userList(HttpServletRequest request,
						   Model model) {
		String url = "myPage/userList";
			
		List<userVO> userList = new ArrayList<userVO>();
		
		int page = 1;
		int boardCount = 0;		
		
		if(request.getParameter("page") != null){
			page = Integer.parseInt(request.getParameter("page"));
		}
		pageVO pageVO = new pageVO();
		pageVO.setPage(page);
		
		userList = user.select_AllUser(page);
		pageVO.setTotalCount(user.get_userCount());
		boardCount = pageVO.getTotalCount();
		
		model.addAttribute("userList", userList);
		model.addAttribute("boardCount", boardCount);
		model.addAttribute("pageVO", pageVO);
		
		/*리다이렉트로 날아온 메세지가 있다면 jsp로 보냄*/
		if(request.getParameter("message") != null) {
			model.addAttribute("message", request.getParameter("message"));
		}
		
		return url;
	}
	
	//관리게시판에서 유저 삭제 (버튼)
	@GetMapping("/delete_User")
	public String delete_User(@RequestParam("user_num")String user_num,
							  @RequestParam("page")String page,
							  Model model) {
		String url = "redirect:/userList";
		int result = 0;

		result = user.delete_User(user_num);
		
		if(result >= 1) {
			model.addAttribute("message", "계정삭제 성공");
		} else {
			model.addAttribute("message", "계정삭제 실패");
		}
		
		model.addAttribute("page", page);
		return url;
	}
	
	//관리페이지의  신고게시판 
	@GetMapping("/reportList")
	public String reportList(HttpServletRequest request,
							 Model model) {
		String url = "myPage/reportList";
		
		List<boardVO> boardList = new ArrayList<boardVO>();
		
		int page = 1;
		int boardCount = 0;
		
		if(request.getParameter("page") != null){
			page = Integer.parseInt(request.getParameter("page"));
		}
		pageVO pageVO = new pageVO();
		pageVO.setPage(page);
		
		boardList = board.select_AllBoard_Report(page);
		pageVO.setTotalCount(user.get_userCount());
		boardCount = pageVO.getTotalCount();
		
		model.addAttribute("boardList", boardList);
		model.addAttribute("boardCount", boardCount);
		model.addAttribute("pageVO", pageVO);
		
		/*리다이렉트로 날아온 메세지가 있다면 jsp로 보냄*/
		if(request.getParameter("message") != null) {
			model.addAttribute("message", request.getParameter("message"));
		}
		
		return url;
	} 
	
	//관리 게시판에서 글 삭제 (버튼)
	@GetMapping("/delete_Board_Report")
	public String delete_Board(HttpSession session, HttpServletRequest request,
							  @RequestParam("board_num")String board_num,
							  @RequestParam("page")String page,
							  Model model) {
		
		String url = "redirect:/reportList";
		board.delete_Board(board_num);
		
		model.addAttribute("message", "글을 삭제했습니다.");
		model.addAttribute("page", page);
		
		return url;		
	}
	
	//뷰
	@GetMapping("/reportView")
	public String reportView(HttpSession session, HttpServletRequest request,
							@RequestParam("board_num")String board_num,
							@RequestParam("board_id")String board_id,
							Model model) {
		
		String url = "myPage/report_View";
		
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
	
	
}
