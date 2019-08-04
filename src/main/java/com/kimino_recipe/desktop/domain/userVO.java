package com.kimino_recipe.desktop.domain;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class userVO {
	private int user_num;
	private String user_id;
	private String user_pass;
	private String user_name;
	private String user_email;
	private Timestamp signdate;
	private String name;
	private String phone_num;
	private String address1;
	private String address2;
}
