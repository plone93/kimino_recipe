package com.kimino_recipe.desktop.domain;

import lombok.Data;

@Data
public class cartVO {
	private int cart_num; 
	private String user_id; // 유저 아이디
	private String product_name; // 상품 이름
	private int price; // 가격
	private String content; // 내용
	private String image; //이미지
	private int amount; //수량
	
}
