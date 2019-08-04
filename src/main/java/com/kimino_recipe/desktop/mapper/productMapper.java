package com.kimino_recipe.desktop.mapper;

import java.util.HashMap;
import java.util.List;

import com.kimino_recipe.desktop.domain.boardVO;
import com.kimino_recipe.desktop.domain.productVO;

public interface productMapper {
	/*구매*/
	public List<boardVO> select_AllBoard(HashMap<String, Object> map);//게시판에  작성된 글 리스트를 불러옴
	public int get_BoardCount(String board_id); // 몇개의 글이 작성됐는지 검색
	public void insert_Board(HashMap<String, Object> map); //글쓰기
	public productVO boardView(String product_num); // 글 내용 보기
	public int addCart(HashMap<String, Object> map); //선택한 상품을 카드에 담기
	
	/*카트*/
	public List<boardVO> select_Cart(HashMap<String, Object> map); //카트목록 검색
	public int get_CartCount(String user_id); // 카트 에 담겨진 상품 갯수
	public int totalPrice(String user_id);//장바구니 상품 총 가격
	public int amount_Up(HashMap<String, Object> map ); // 상품 수량 증가
	public int amount_Down(HashMap<String, Object> map ); // 상품 수량 감소
	public void cart_Delete(String cart_num); // 카트에서 상품 삭제
	public int insert_OrderList(HashMap<String, Object> map); // 주문완료 후 주문 리스트에 입력
	
	/*주문이력*/
	public List<productVO> orderView(HashMap<String, Object> map); //주문id에 해당하는 리스트 가져옴
	public int get_orderCount(String order_id); //주문id에 해당하는 주문건수


}
