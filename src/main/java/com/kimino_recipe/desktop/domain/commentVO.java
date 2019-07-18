package com.kimino_recipe.desktop.domain;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class commentVO {
	private int comment_num;
	private String board_num;
	private String board_id;
	private String user_id;
	private String user_name;
	private String content;
	private Timestamp writedate;
	
	
	//recipe_board_comment
}
