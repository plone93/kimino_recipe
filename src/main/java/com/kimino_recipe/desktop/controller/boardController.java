package com.kimino_recipe.desktop.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.kimino_recipe.desktop.domain.boardVO;
import com.kimino_recipe.desktop.domain.commentVO;
import com.kimino_recipe.desktop.domain.countVO;
import com.kimino_recipe.desktop.domain.pageVO;
import com.kimino_recipe.desktop.domain.userVO;
import com.kimino_recipe.desktop.service.boardService;
import com.kimino_recipe.desktop.service.commentService;


import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class boardController {
	
	@Resource(name="uploadPath")
	String uploadPath;
	
	private boardService board;
	private commentService comment;
	
	
	//게시판 리스트
	@GetMapping("/boardList")
	public String boardList(HttpSession session, HttpServletRequest request,
							@RequestParam("board_id") String board_id,
							Model model) {
		
		String url = "recipe/recipe_List";
		List<boardVO> boardList = new ArrayList<boardVO>();
		
		int page = 1;
		int boardCount = 0;
		
		if(request.getParameter("page") != null){
			page = Integer.parseInt(request.getParameter("page"));
		}
		pageVO pageVO = new pageVO();
		pageVO.setPage(page);
		
		boardList = board.select_AllBoard(page, board_id);
		pageVO.setTotalCount(board.get_BoardCount(board_id));
		boardCount = pageVO.getTotalCount();
		
		
		model.addAttribute("boardList", boardList);
		model.addAttribute("boardCount", boardCount);
		model.addAttribute("pageVO", pageVO);
		model.addAttribute("board_id", board_id);
		
		/*일반게시판 공지사항*/
		String noticeBoard_id = "お知らせ";
		List<boardVO> noticeList = board.select_AllBoard_Notice(page, noticeBoard_id);
		model.addAttribute("noticeList", noticeList);
		
		/*리다이렉트로 날아온 메세지가 있다면 jsp로 보냄*/
		if(request.getParameter("message") != null) {
			model.addAttribute("message", request.getParameter("message"));
		}
		
		return url;		
	}
	
	//게시판 리스트
	@GetMapping("/boardList_Comment")
	public String boardList_Comment(HttpSession session, HttpServletRequest request,
							@RequestParam("board_id") String board_id,
							Model model) {
		
		String url = "recipe/recipe_List";
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
		String noticeBoard_id = "お知らせ";
		List<boardVO> noticeList = board.select_AllBoard_Notice(page, noticeBoard_id);
		model.addAttribute("noticeList", noticeList);
		
		/*리다이렉트로 날아온 메세지가 있다면 jsp로 보냄*/
		if(request.getParameter("message") != null) {
			model.addAttribute("message", request.getParameter("message"));
		}
		
		return url;		
	}
	
	//게시판 리스트
	@GetMapping("/boardList_ReadCount")
	public String boardList_ReadCount(HttpSession session, HttpServletRequest request,
							@RequestParam("board_id") String board_id,
							Model model) {
		
		String url = "recipe/recipe_List";
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
		String noticeBoard_id = "お知らせ";
		List<boardVO> noticeList = board.select_AllBoard_Notice(page, noticeBoard_id);
		model.addAttribute("noticeList", noticeList);
		
		/*리다이렉트로 날아온 메세지가 있다면 jsp로 보냄*/
		if(request.getParameter("message") != null) {
			model.addAttribute("message", request.getParameter("message"));
		}
		
		return url;		
	}
	
	//게시판 리스트
	@GetMapping("/boardList_Up")
	public String boardList_Up(HttpSession session, HttpServletRequest request,
							@RequestParam("board_id") String board_id,
							Model model) {
		
		String url = "recipe/recipe_List";
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
		String noticeBoard_id = "お知らせ";
		List<boardVO> noticeList = board.select_AllBoard_Notice(page, noticeBoard_id);
		model.addAttribute("noticeList", noticeList);
		
		/*리다이렉트로 날아온 메세지가 있다면 jsp로 보냄*/
		if(request.getParameter("message") != null) {
			model.addAttribute("message", request.getParameter("message"));
		}
		
		return url;		
	}
	
	//게시판 리스트
	@GetMapping("/boardList_Down")
	public String boardList_Down(HttpSession session, HttpServletRequest request,
							@RequestParam("board_id") String board_id,
							Model model) {
		
		String url = "recipe/recipe_List";
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
		String noticeBoard_id = "お知らせ";
		List<boardVO> noticeList = board.select_AllBoard_Notice(page, noticeBoard_id);
		model.addAttribute("noticeList", noticeList);
		
		/*리다이렉트로 날아온 메세지가 있다면 jsp로 보냄*/
		if(request.getParameter("message") != null) {
			model.addAttribute("message", request.getParameter("message"));
		}
		
		return url;		
	}
	
	//뷰
	@GetMapping("/boardView")
	public String boardView(HttpSession session, HttpServletRequest request,
							@RequestParam("board_num")String board_num,
							@RequestParam("board_id")String board_id,
							Model model) {
		
		String url = "recipe/recipe_View";
		
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
	@GetMapping("/insert_Board")
	public String insert_Board(HttpSession session, HttpServletRequest request,
							@RequestParam("board_id")String board_id,
							Model model) {

		String url = "recipe/recipe_Write";
		model.addAttribute("board_id", board_id);
		
		return url;		
	}
	
	
	//글쓰기
	@PostMapping("/inserted_Board")
	public String inserted_Board(HttpSession session, HttpServletRequest request,
							@RequestParam("board_id")String board_id,
							boardVO boardVO,
							Model model,
							MultipartFile file) {

		String url = "redirect:/boardList";
		
		try {
			/*파일 업로드*/
			if(file.getOriginalFilename() != null) { //파일이 업로드 되어서  이름이 가져와지는 경우
				String image = file.getOriginalFilename();
				boardVO.setImage(image);
				File target = new File(uploadPath, image);
				FileCopyUtils.copy(file.getBytes(), target);//파일 액세스 권한오류가 발생하나 무시
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		boardVO.setBoard_id(board_id);
		board.insert_Board(boardVO, board_id);
		model.addAttribute("board_id", board_id);

		return url;		
	}
	
	//글 수정
	@GetMapping("/edit_Board")
	public String edit_Board(HttpSession session, HttpServletRequest request,
							@RequestParam("board_num")String board_num,
							@RequestParam("board_id")String board_id,
							@RequestParam("page")String page,
							Model model) {
		
		String url = "recipe/recipe_ReWrite";
		boardVO boardVO = board.boardView(board_num);
		
		model.addAttribute("boardVO", boardVO);
		model.addAttribute("board_id", board_id);
		model.addAttribute("page", page);
		
		return url;		
	}
	
	//글 수정 완료
	@PostMapping("/edited_Board")
	public String edited_Board(HttpSession session, HttpServletRequest request,
							  @RequestParam("board_id")String board_id,
							  @RequestParam("board_num")String board_num,
							  @RequestParam("page")String page,
							  boardVO boardVO,
							  Model model) {
		
		String url = "redirect:/boardView";
		int result = board.update_Board(boardVO, board_num);
		
		if(result == 1) { /* 1 : 업데이트 성공*/
			model.addAttribute("message", "更新しました。");
		} else {
			model.addAttribute("message", "修正に失敗しました。");
		}
		model.addAttribute("board_id", board_id);
		model.addAttribute("board_num", board_num);
		model.addAttribute("page", page);
		
		return url;		
	}
	
	//글 삭제
	@GetMapping("/delete_Board")
	public String delete_Board(HttpSession session, HttpServletRequest request,
							  @RequestParam("board_id")String board_id,
							  @RequestParam("board_num")String board_num,
							  @RequestParam("page")String page,
							  Model model) {
		
		String url = "redirect:/boardList";
		board.delete_Board(board_num);
		
		model.addAttribute("board_id", board_id);
		model.addAttribute("message", "削除しました。");
		model.addAttribute("page", page);
		
		return url;		
	}
	
	//추천
	@GetMapping("/board_Up")
	public String board_Up(HttpSession session, HttpServletRequest request, HttpServletResponse response,
						  @RequestParam("board_id")String board_id,
						  @RequestParam("board_num")String board_num,
						  @RequestParam("page")String page,
						  Model model) {
		
		String url = "redirect:/boardView";
		
		//쿠키 
		Boolean found = false;
		Cookie info = null;
		Cookie[] cookies = request.getCookies();
		//쿠키 유뮤 검사
		for(int i=0; i < cookies.length; i++) {
			info = cookies[i];
			if(info.getName().equals("Kiminorecipe_boardUp"+board_num)) { //이름 = 쿠키이름+글번호
				found = true;
				break;
			}
		}
		String str = ""+System.currentTimeMillis();//시간을 쪼갬
		if(found) { //쿠키가 있다면  알림창
			model.addAttribute("message", "既にクリックしました。"); //경고창
		}else if(!found) {  //쿠키가 없다면
			info = new Cookie("Kiminorecipe_boardUp"+board_num, str);
			info.setMaxAge(24*60*60); //쿠키 유효 시간 설정
			response.addCookie(info);
			board.update_UpCount(board_num);
		}
		
		
		countVO countVO = board.get_TotalCount(board_num);
		
		model.addAttribute("countVO", countVO);
		model.addAttribute("board_id", board_id);
		model.addAttribute("board_num", board_num);
		model.addAttribute("page", page);
		
		return url;		
	}
	
	//비추천
	@GetMapping("/board_Down")
	public String board_Down(HttpSession session, HttpServletRequest request, HttpServletResponse response,
							@RequestParam("board_num")String board_num,
							@RequestParam("board_id")String board_id,
							@RequestParam("page")String page,
							Model model) {
		
		String url = "redirect:/boardView";
		
		//쿠키 
		Boolean found = false;
		Cookie info = null;
		Cookie[] cookies = request.getCookies();
		//쿠키 유뮤 검사
		for(int i=0; i < cookies.length; i++) {
			info = cookies[i];
			if(info.getName().equals("Kiminorecipe_boardDown"+board_num)) { //이름 = 쿠키이름+글번호
				found = true;
				break;
			}
		}
		String str = ""+System.currentTimeMillis();//시간을 쪼갬
		if(found) { //쿠키가 있다면  알림창
			model.addAttribute("message", "既にクリックしました。"); //경고창
		}else if(!found) {  //쿠키가 없다면
			info = new Cookie("Kiminorecipe_boardDown"+board_num, str);
			info.setMaxAge(24*60*60); //쿠키 유효 시간 설정
			response.addCookie(info);
			board.update_DownCount(board_num);
		}
		
		
		countVO countVO = board.get_TotalCount(board_num);
		
		model.addAttribute("countVO", countVO);
		model.addAttribute("board_id", board_id);
		model.addAttribute("board_num", board_num);
		
		return url;	
		
	}
	
	//신고
	@GetMapping("/board_Report")
	public String board_Report(HttpSession session, HttpServletRequest request, HttpServletResponse response,
							  @RequestParam("board_num")String board_num,
							  @RequestParam("board_id")String board_id,
							  @RequestParam("page")String page,
							  Model model) {
		
		String url = "redirect:/boardView";
		
		//쿠키 
		Boolean found = false;
		Cookie info = null;
		Cookie[] cookies = request.getCookies();
		//쿠키 유뮤 검사
		for(int i=0; i < cookies.length; i++) {
			info = cookies[i];
			if(info.getName().equals("Kiminorecipe_boardReport"+board_num)) { //이름 = 쿠키이름+글번호
				found = true;
				break;
			}
		}
		String str = ""+System.currentTimeMillis();//시간을 쪼갬
		if(found) { //쿠키가 있다면  알림창
			model.addAttribute("message", "既にクリックしました。"); //경고창
		}else if(!found) {  //쿠키가 없다면
			info = new Cookie("Kiminorecipe_boardReport"+board_num, str);
			info.setMaxAge(24*60*60); //쿠키 유효 시간 설정
			response.addCookie(info);
			board.update_ReportCount(board_num);
		}	
		
		countVO countVO = board.get_TotalCount(board_num);
		
		model.addAttribute("countVO", countVO);
		model.addAttribute("board_id", board_id);
		model.addAttribute("board_num", board_num);
		model.addAttribute("page", page);
		
		return url;	
		
	}
	

}
