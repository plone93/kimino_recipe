package com.kimino_recipe.desktop.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.kimino_recipe.desktop.domain.adminVO;
import com.kimino_recipe.desktop.domain.userVO;
import com.kimino_recipe.desktop.mapper.userMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class userServiceImpl implements userService {
	
	/*유저(멤버) */
	userMapper user;
	
	@Override
	public int insert_User(userVO userVO) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("userVO", userVO);
		
		return user.insert_User(map);
	}

	@Override
	public userVO get_User(String user_id) {
		return user.get_User(user_id);
	}

	@Override
	public adminVO get_Admin(String user_id) {
		return user.get_Admin(user_id);
	}

	@Override
	public int update_User(userVO userVO, String user_num) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("userVO", userVO);
		map.put("user_num", user_num);
		
		return user.update_User(map);
	}

	@Override
	public String get_UserPass(String user_num) {
		return user.get_UserPass(user_num);
	}

	@Override
	public int delete_User(String user_num) {
		return user.delete_User(user_num);
	}

	@Override
	public int idCheck(String id) {
		return user.idCheck(id);
	}
	
	@Override
	public int emailCheck(String user_email) {
		return user.emailCheck(user_email);
	}

	@Override
	public int nameCheck(String name) {
		return user.nameCheck(name);
	}
	
	@Override
	public int emailUpdate(String user_num, String user_email) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("user_num", user_num);
		map.put("user_email", user_email);
		
		return user.emailUpdate(map);
	}

	@Override
	public int nameUpdate(String user_num, String user_name) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("user_num", user_num);
		map.put("user_name", user_name);
		
		return user.nameUpdate(map);
	}

	@Override
	public int passUpdate(String user_num, String user_pass) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("user_num", user_num);
		map.put("user_pass", user_pass);
		
		return user.passUpdate(map);
	}

	@Override
	public List<userVO> select_AllUser(int page) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		int startNum = (page-1)*10+1;
		int endNum = page*10;
		
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		
		return user.select_AllUser(map);
	}

	@Override
	public int get_userCount() {
		return user. get_userCount();
	}

	@Override
	public int emailUpdate_Admin(String admin_num, String admin_email) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("admin_num", admin_num);
		map.put("admin_email", admin_email);
		
		return user.emailUpdate_Admin(map);
		
	}

	@Override
	public int nameUpdate_Admin(String admin_num, String admin_name) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("admin_num", admin_num);
		map.put("admin_name", admin_name);
		
		return user.nameUpdate_Admin(map);
		
	}

	@Override
	public int passUpdate_Admin(String admin_num, String admin_pass) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("admin_num", admin_num);
		map.put("admin_pass", admin_pass);
		
		return user.passUpdate_Admin(map);
	}

	@Override
	public int emailCheck_Admin(String admin_email) {
		return user.emailCheck_Admin(admin_email);
	}

	@Override
	public int update_Name(int user_num, String name) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("user_num", user_num);
		map.put("name", name);
		
		return user.update_Name(map);
	}

	@Override
	public int update_Address(int user_num, String address1, String address2) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("user_num", user_num);
		map.put("address_A", address1); //쿼리문을 처리할때 변수에 숫자를 쓰면 에러가 발생하므로  문자로 변환
		map.put("address_B", address2); //쿼리문을 처리할때 변수에 숫자를 쓰면 에러가 발생하므로  문자로 변환
		
		return user.update_Address(map);
	}

	@Override
	public int update_Phone_num(int user_num, String phone_num) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("user_num", user_num);
		map.put("phone_num", phone_num);
		
		return user.update_Phone_num(map);
	}




	
	
}
