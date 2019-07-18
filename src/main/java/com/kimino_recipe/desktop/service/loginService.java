package com.kimino_recipe.desktop.service;


public interface loginService {
	
	/*로그인*/	
	public int login_User(String id, String pass); //유저 로그인
	public int login_Admin(String id, String pass); //관리자 로그인

}
