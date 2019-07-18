package com.kimino_recipe.desktop.service;

import java.util.HashMap;

import org.springframework.stereotype.Service;

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
	public userVO get_Admin(String user_num) {
		return user.get_Admin(user_num);
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

}
