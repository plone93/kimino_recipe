package com.kimino_recipe.desktop.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.kimino_recipe.desktop.domain.boardVO;
import com.kimino_recipe.desktop.domain.cartVO;
import com.kimino_recipe.desktop.domain.orderVO;
import com.kimino_recipe.desktop.domain.productVO;
import com.kimino_recipe.desktop.mapper.productMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class productServiceImpl implements productService {
	
	productMapper product;
	
	@Override
	public List<boardVO> select_AllBoard(int page, String board_id) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		int startNum = (page-1)*10+1;
		int endNum = page*10;
		
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		map.put("board_id", board_id);
		
		return product.select_AllBoard(map);
	}

	@Override
	public int get_BoardCount(String board_id) {
		return product.get_BoardCount(board_id);
	}

	@Override
	public void insert_Board(productVO productVO, String board_id) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("productVO", productVO);
		map.put("board_id", board_id);
		
		product.insert_Board(map);
	}

	@Override
	public productVO boardView(String product_num) {
		return product.boardView(product_num);
	}

	@Override
	public int addCart(cartVO cartVO) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("cartVO", cartVO);
		
		return product.addCart(map);
	}

	@Override
	public List<boardVO> select_Cart(int page, String user_id) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		int startNum = (page-1)*10+1;
		int endNum = page*10;
		
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		map.put("user_id", user_id);
		
		return product.select_Cart(map);
	}

	@Override
	public int get_CartCount(String user_id) {
		return product.get_CartCount(user_id);
	}

	@Override
	public int totalPrice(String user_id) {
		return product.totalPrice(user_id);
		
	}

	@Override
	public int amount_Up(String user_id, String cart_num) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("user_id", user_id);
		map.put("cart_num", cart_num);
		
		return product.amount_Up(map);
	}

	@Override
	public int amount_Down(String user_id, String cart_num) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("user_id", user_id);
		map.put("cart_num", cart_num);
		
		return product.amount_Down(map);
	}

	@Override
	public void cart_Delete(String cart_num) {
		product.cart_Delete(cart_num);
		
	}

	@Override
	public int insert_OrderList(orderVO orderVO, String product_id, String product_name, String price, String amount, String order_id) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("orderVO", orderVO);
		map.put("product_id", product_id);
		map.put("product_name", product_name);
		map.put("price", price);
		map.put("amount", amount);
		map.put("order_id", order_id);
		
		return product.insert_OrderList(map);
	}

	@Override
	public List<productVO> orderView(int page, String order_id) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		int startNum = (page-1)*10+1;
		int endNum = page*10;
		
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		map.put("order_id", order_id);
		
		return product.orderView(map);
	}

	@Override
	public int get_orderCount(String order_id) {
		return product.get_orderCount(order_id);
	}
	
	
}
