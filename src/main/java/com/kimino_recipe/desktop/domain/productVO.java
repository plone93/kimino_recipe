package com.kimino_recipe.desktop.domain;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class productVO {
	private int product_num; //상품 번호
	private String product_name; //상품 이름
	private int price; //상품 가격
	private String content; //상품 설명
	private String image; //상품 이미지1
	private Timestamp writedate; //작성일
	private String board_id;
}
