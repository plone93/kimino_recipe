package com.kimino_recipe.desktop.service;

import java.util.List;

import com.kimino_recipe.desktop.domain.adminVO;
import com.kimino_recipe.desktop.domain.userVO;


public interface userService {
	
	/*유저(멤버)*/
	public int insert_User(userVO userVO); //회원가입
	public userVO get_User(String user_id); //회원정보수정창에 띄울 가입정보
	public int update_User(userVO userVO, String user_num); //회원정보수정 갱신
	public String get_UserPass(String user_num); // 회원탈퇴 할때  패스워드로 본인인증 
	public int delete_User(String user_num); // 회원탈퇴
	public int idCheck(String id); //회원가입할때 아이디 중복확인
	public int emailCheck(String user_email); //이메일 중복확인 체크
	public int nameCheck(String name);//회원가입 할 때 닉네임 중복확인
	public int emailUpdate(String user_num, String user_email);//이메일 변경
	public int nameUpdate(String user_num, String user_name);//내정보창에서 닉네임 변경 
	public int passUpdate(String user_num, String user_pass);//내정보창에서 비밀번호 변경
	public int update_Name(int user_num, String name); //주문할때 이름 갱신
	public int update_Address(int user_num, String address1, String address2); //주문할때 주소 갱신
	public int update_Phone_num(int user_num, String phone_num); //주문할때 연락처 갱신
	
	/*주문내역 > 주문상품 > 갱신*/
	public int update_OrderName(String name, String order_id);//주문한 상품 수령인 이름 변경
	
	/*관리자*/
	public adminVO get_Admin(String admin_id); //회원정보수정 임시
	public int emailCheck_Admin(String admin_email); //이메일 중복확인 체크
	public int emailUpdate_Admin(String admin_num, String admin_email);//이메일 변경
	public int nameUpdate_Admin(String admin_num, String admin_name);//내정보창에서 닉네임 변경 
	public int passUpdate_Admin(String admin_num, String admin_pass);//내정보창에서 비밀번호 변경
	public List<userVO> select_AllUser(int page); //관리자 게시판에서 유저리스트 로드
	public int get_userCount();// 총 회원수 



	
	
	
	

}
