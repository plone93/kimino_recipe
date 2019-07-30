package com.kimino_recipe.desktop.service;

import java.util.List;

import com.kimino_recipe.desktop.domain.boardVO;
import com.kimino_recipe.desktop.domain.cartVO;
import com.kimino_recipe.desktop.domain.productVO;

public interface productService {
	/*쇼핑*/
	public List<boardVO> select_AllBoard(int page, String board_id); //게시판의 모든 글을 검색
	public int get_BoardCount(String board_id); // 게시판에 몇개의 글이 있는지 검색
	public void insert_Board(productVO productVO, String board_id); //글쓰기
	public productVO boardView(String product_num); // 글 내용 보기
	public int addCart(cartVO cartVO);// 선택한 상품을 카드에 담기
	
	/*카트*/
	public List<boardVO> select_Cart(int page, String user_id); // 카트 목록 보기
	public int get_CartCount(String user_id); // 카트에 담겨있는 상품 개수
	public int totalPrice(String user_id);//장바구니 상품 총가격
	public int amount_Up(String user_id, String cart_num);//상품 수량 증가
	public int amount_Down(String user_id, String cart_num);//상품 수량 감수
	public void cart_Delete(String cart_num);//카트에서 상품 삭제
	
}
