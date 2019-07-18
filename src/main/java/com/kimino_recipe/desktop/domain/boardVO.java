package com.kimino_recipe.desktop.domain;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class boardVO {
	private int board_num;
	private String board_id;
	private String user_id;
	//private String user_pass;
	private String user_name;
	private String title;
	private String content;
	private String image;
	private int readcount;
	private int up;
	private int down;
	private int report;
	private Timestamp writedate;
	
	
	//recipe_board

}
