package com.kimino_recipe.desktop.mapper;

import java.util.HashMap;

public interface loginMapper {
	
	/*로그인*/	
	public int login_User(HashMap<String, Object> map); //유저 로그인
	public int login_Admin(HashMap<String, Object> map); //관리자 로그인


}
