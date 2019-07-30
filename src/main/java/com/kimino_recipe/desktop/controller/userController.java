package com.kimino_recipe.desktop.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kimino_recipe.desktop.domain.userVO;
import com.kimino_recipe.desktop.service.loginService;
import com.kimino_recipe.desktop.service.userService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class userController {
	
	private loginService login;
	private userService user;
	
	//유저 회원가입 버튼 
	@GetMapping("/insert_User")
	public String register(HttpSession session, HttpServletRequest request) {
		String url = "signUp/signUp";
		return url;
	}
	
	//유저 회원가입 완료
	@PostMapping("/inserted_User")
	public String  registered(HttpSession session, HttpServletRequest request,
							 userVO userVO,
							 Model model) {
				String url = "redirect:/main";
				user.insert_User(userVO);
				model.addAttribute("message", "회원가입 성공");

		return url;		
	}
	
	//유저 로그인 버튼
	@GetMapping("/login_User")
	public String userLogin(HttpSession session, HttpServletRequest request) {
		String url = "login/login_User";
		return url;
	}
	
	//유저 로그인 완료
	@PostMapping("/logined_User")
	public String userLogined(HttpSession session, HttpServletRequest request,
						  @RequestParam("user_id")String user_id,
						  @RequestParam("user_pass")String user_pass,
						  Model model) {
		
		String url = "redirect:/main";
		int result = 0;
		
		result = login.login_User(user_id, user_pass);
		
		if(result >= 1) { /*결과 값이 1이라면 로그인에 성공*/
			userVO userVO = user.get_User(user_id);
			session = request.getSession();
			session.setAttribute("loginUser", userVO);
			model.addAttribute("message", "로그인 성공");
		} else if(result == 0) {
			model.addAttribute("message", "아이디나 비밀번호 확인해주셈");
			url = "login/login_User";
		}
		
		return url;	
	}
	
	
	//회원정보수정 버튼
	@GetMapping("/edit_Profile")
	public String editProfile(HttpSession session, HttpServletRequest request,
							@RequestParam("user_id")String user_id,
							Model model) {
		String url = "myPage/edit_Profile";
		userVO userVO = user.get_User(user_id);
		
		model.addAttribute("userVO", userVO);
		
		return url;
	}
	
	//회원정보 수정 완료
	@PostMapping("/edited_Profile")
	public String editedProfile(HttpSession session, HttpServletRequest request,
								@RequestParam("user_num")String user_num,
								userVO userVO,
								Model model) {
		String url = "";
		int result = 0;
		result = user.update_User(userVO, user_num);
		
		if(result == 1) {
			model.addAttribute("message", "회원정보수정 완료");
		} else if(result == 0) {
			model.addAttribute("message", "회원정보수정 실패");
		}
		
		return url;	
	}
	
	//회원탈퇴 버튼
	@GetMapping("/cancel_User")
	public String userCancel(HttpSession session, HttpServletRequest request) {
		String url = "myPage/myPage_Close";
		
		return url;
	}
	
	//회원탈퇴 완료 , 탈퇴 전 패스워드로 본인확인 해야함
	@PostMapping("/canceled_User")
	public String userCanceled(HttpSession session, HttpServletRequest request,
							   @RequestParam("user_num")String user_num,
							   @RequestParam("user_pass")String user_pass,
							   @RequestParam("input_Pass")String input_pass,
							   Model model) {
		String url = "redirect:/main";
		
		if(user_pass == input_pass) {
			user.delete_User(user_num);
			model.addAttribute("message", "계정삭제 성공");
		} else {
			model.addAttribute("message", "계정삭제 실패");
		}
		
		return url;
		
	}
	
	//로그아웃
	@GetMapping("/logout")
	public String logout(HttpSession session, HttpServletRequest request,
						Model model) {
		
		String url = "redirect:/main";
		session = request.getSession();
		session.invalidate();
		model.addAttribute("message", "로그아웃했다눙");
		
		return url;		
	}
	
	//아이디 중복 체크
	@ResponseBody
	@PostMapping("/idCheck")
	public int idCheck(HttpSession session, HttpServletRequest request,
					   @RequestParam("id")String id,
					   Model model) {
		
		int idCheck = 0;
		int result = 0;
		idCheck = user.idCheck(id);	
		
		if(idCheck == 1) {
			result = 1; /* 1이면 중복된 아이디가 검색되서 1이 리턴됐으므로 사용불가, 검색된 행의 갯수를 리턴함 */
			model.addAttribute("result", result);
		} else if(idCheck == 0){
			model.addAttribute("result", result);
		}
		
		return result;		
	}
	
	//이름 중복 체크
	@ResponseBody
	@PostMapping("/nameCheck")
	public int nameCheck(HttpSession session, HttpServletRequest request,
					   @RequestParam("name")String name,
					   Model model) {
		
		int nameCheck = 0;
		int result = 0;
		nameCheck = user.nameCheck(name);
		
		
		if(nameCheck == 1) {
			result = 1; /* 1이면 중복된 아이디가 검색되서 1이 리턴됐으므로 사용불가, 검색된 행의 갯수를 리턴함 */
			model.addAttribute("result", result);
		} else if(nameCheck == 0){
			model.addAttribute("result", result);
		}
		
		return result;		
	}
	
	//이메일 갱신
	@ResponseBody
	@PostMapping("/emailUpdate")
	public int emailUpdate(HttpSession session, HttpServletRequest request,
					   @RequestParam("user_email")String user_email,
					   @RequestParam("user_num")String user_num,
					   Model model) {
		
		int emailCheck = 0;
		int result = 0; //jsp에서 ajax를 통해 결과를 알려줄 변수
		emailCheck = user.emailCheck(user_email);
		
		
		if(emailCheck >= 1) {
			result = 1; /* 1이면 중복된 이메일 검색되서 1이상이 리턴됐으므로 사용불가, 검색된 행의 갯수를 리턴함 */
			model.addAttribute("result", result);	
		} else if(emailCheck == 0){ // 중복이 없음
			user.emailUpdate(user_num, user_email); //이메일 변경
			model.addAttribute("result", result);	
		}
		
		return result;		
	}
	
	//닉네임 갱신
	@ResponseBody
	@PostMapping("/nameUpdate")
	public int nameUpdate(HttpSession session, HttpServletRequest request,
					   @RequestParam("user_name")String user_name,
					   @RequestParam("user_num")String user_num,
					   Model model) {
		
		int nameCheck = 0;
		int result = 0; //jsp에서 ajax를 통해 결과를 알려줄 변수
		nameCheck = user.nameCheck(user_name);
		
		
		if(nameCheck >= 1) {
			result = 1; /* 1이면 중복된 아이디가 검색되서 1이 리턴됐으므로 사용불가, 검색된 행의 갯수를 리턴함 */
			model.addAttribute("result", result);	
		} else if(nameCheck == 0){
			user.nameUpdate(user_num, user_name); //닉네임 변경
			model.addAttribute("result", result);	
		}
		
		return result;		
	}
	
	
	//비밀번호 갱신
	@ResponseBody
	@PostMapping("/passUpdate")
	public int passUpdate(HttpSession session, HttpServletRequest request,
					   @RequestParam("user_pass")String user_pass,
					   @RequestParam("user_num")String user_num,
					   Model model) {
		
		int result = 0; //jsp에서 ajax를 통해 결과를 알려줄 변수
		
		result = user.passUpdate(user_num, user_pass);
		model.addAttribute("result", result);
		
		return result;		
	}
	

}
