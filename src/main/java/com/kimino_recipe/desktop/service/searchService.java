package com.kimino_recipe.desktop.service;

import java.util.List;

import com.kimino_recipe.desktop.domain.boardVO;
import com.kimino_recipe.desktop.domain.searchVO;
import com.kimino_recipe.desktop.domain.userVO;

public interface searchService {

	/*일반 게시판 검색*/
	public List<boardVO> search(int page, searchVO searchVO, String board_id); // 게시판 내 검색
	public int search_Count(searchVO searchVO, String board_id); // 검색한 내용으로 몇개 검색 됐는지 가져옴
	
	/*공지사항 검색*/
	public List<boardVO> search_Notice(String board_id);// 공지사항 검색
	public List<boardVO> search_Count_Notice(String board_id);// 공지사항 검색 갯수
	
	/*추천  검색*/
	public List<boardVO> search_Up(int page, searchVO searchVO, String hotcount); //추천,비추천 게시판 내 검색 후 해당 게시글 리스트 
	public int search_Count_Up(searchVO searchVO, String hotcount); //추천,비추천 게시판 내 검색 후 몇건 검색 됐는지
	
	/*비추천  검색*/
	public List<boardVO> search_Down(int page, searchVO searchVO, String hotcount); //추천,비추천 게시판 내 검색 후 해당 게시글 리스트 
	public int search_Count_Down(searchVO searchVO, String hotcount); //추천,비추천 게시판 내 검색 후 몇건 검색 됐는지
	
	/*신고 검색*/
	public List<boardVO> search_Report(int page, searchVO searchVO);
	public int search_Count_Report(searchVO searchVO);
	
	/*통합 게시판 검색*/
	public List<boardVO> search_Total(int page, searchVO searchVO);
	public int search_Count_Total(searchVO searchVO);
	
	/*회원관리 검색*/
	public List<userVO> search_User(int page, searchVO searchVO);
	public int search_Count_User(searchVO searchVO);
	
	/*일반 게시판 검색*/
	public List<boardVO> search_Product(int page, searchVO searchVO, String board_id); // 게시판 내 검색
	public int search_Count_Product(searchVO searchVO, String board_id); // 검색한 내용으로 몇개 검색 됐는지 가져옴
}
