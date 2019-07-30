package com.kimino_recipe.desktop.domain;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class adminVO {
	private int admin_num;
	private String admin_id;
	private String admin_pass;
	private String admin_name;
	private String admin_email;
	private Timestamp signdate;
}
