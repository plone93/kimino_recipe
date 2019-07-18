package com.kimino_recipe.desktop.mapper;

import java.util.HashMap;

import com.kimino_recipe.desktop.domain.userVO;

public interface userMapper {
	
	/*유저(멤버) */
	public int insert_User(HashMap<String, Object> map); //회원가입
	public userVO get_User(String user_num); //회원정보수정창에 띄울 가입정보
	public userVO get_Admin(String user_num); //회원정보수정 임시
	public int update_User(HashMap<String, Object> map); //회원정보수정 갱신
	public String get_UserPass(String user_num); // 회원탈퇴 할때  패스워드로 본인인증 
	public int delete_User(String user_num); // 회원탈퇴
	public int idCheck(String id); //회원가입할때 아이디 중복확인
}
