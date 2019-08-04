package com.kimino_recipe.desktop.mapper;

import java.util.HashMap;
import java.util.List;

import com.kimino_recipe.desktop.domain.adminVO;
import com.kimino_recipe.desktop.domain.userVO;

public interface userMapper {
	
	/*유저(멤버)*/
	public int insert_User(HashMap<String, Object> map); //회원가입
	public userVO get_User(String user_num); //회원정보수정창에 띄울 가입정보
	public int update_User(HashMap<String, Object> map); //회원정보수정 갱신
	public String get_UserPass(String user_num); // 회원탈퇴 할때  패스워드로 본인인증 
	public int delete_User(String user_num); // 회원탈퇴
	public int idCheck(String id); //회원가입할때 아이디 중복확인
	public int emailCheck(String user_email); //이메일 중복확인 체크
	public int nameCheck(String name); //닉네임 중복체크
	public int emailUpdate(HashMap<String, Object> map); //이메일 변경
	public int nameUpdate(HashMap<String, Object> map);//개인정보창에서 닉네임 변경
	public int passUpdate(HashMap<String, Object> map);//개인정보창에서 비밀번호 변경
	public int update_Name(HashMap<String, Object> map);  // 주문창에서 이름 변경
	public int update_Address(HashMap<String, Object> map); // 주문창에서 주소변경
	public int update_Phone_num(HashMap<String, Object> map); //주문창에서 연락처 변경
	
	/*관리자*/
	public adminVO get_Admin(String user_id); //회원정보수정 임시
	public List<userVO> select_AllUser(HashMap<String, Object> map); //유저 리스트
	public int get_userCount();//총 회원수
	public int emailUpdate_Admin(HashMap<String, Object> map); //관리자 이메일 변경
	public int nameUpdate_Admin(HashMap<String, Object> map); // 관리자 닉네임 변경
	public int passUpdate_Admin(HashMap<String, Object> map); // 관리자 비밀번호 변경
	public int emailCheck_Admin(String admin_email);// 관리자 이메일 중복체크
	
	
}
