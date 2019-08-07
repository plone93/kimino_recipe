package com.kimino_recipe.desktop.domain;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class orderVO {
	private String user_id; //유저 아이디
	private String product_id;  //상품 아이디
	private String product_name;  //상품이름
	private String price;  //가격
	private String amount;  //수량
	private String name;  // 주문자 이름
	private String phone_num;  //연락처
	private String address1;  //주소1
	private String address2; //주소2
	private String bank_account; //계좌번호
	private Timestamp orderdate; //주문 날짜
	private String order_id; // 주문 아이디
	private int delivery; //주문현황
	private String image; //이미지
	private String message; //배송 메세지
	private String post_num; //배송추적번호
	/*주문완료된 제품을 카트에서 제거하기 위한 변수*/
	private String cart_num;

	/*
	 * String 타입은  jsp에서  반복문으로 넘기면  배열로 받아오지만 (aaa,bbb,ccc)
	 * int 타입은  jsp에서 반복문으로 넘기면  배열로 받아오지 못하고 첫번째 값만 받아옴
	 * */
}
