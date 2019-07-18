package com.kimino_recipe.desktop.service;

import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.kimino_recipe.desktop.mapper.loginMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class loginServiceImpl implements loginService {
	
	/*로그인*/
	loginMapper login;
	
	@Override
	public int login_User(String id, String pass) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("pass", pass);
		
		return login.login_User(map);
	}

	@Override
	public int login_Admin(String id, String pass) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("pass", pass);
		
		return login.login_Admin(map);
	}
	
	/*로그인 끝*/
	
}
