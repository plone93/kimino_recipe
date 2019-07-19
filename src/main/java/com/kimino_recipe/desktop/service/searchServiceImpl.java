package com.kimino_recipe.desktop.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.kimino_recipe.desktop.domain.boardVO;
import com.kimino_recipe.desktop.domain.searchVO;
import com.kimino_recipe.desktop.domain.userVO;
import com.kimino_recipe.desktop.mapper.searchMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class searchServiceImpl implements searchService {
	
	searchMapper search;
	
	/*일반 게시판 검색 */ 
	@Override
	public List<boardVO> search(int page, searchVO searchVO, String board_id) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		int startNum = (page-1)*10+1;
		int endNum = page*10;
		
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		map.put("searchVO", searchVO);
		map.put("board_id", board_id);
		
		return search.search(map);
	}

	@Override
	public int search_Count(searchVO searchVO, String board_id) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("searchVO", searchVO);
		map.put("board_id", board_id);
		
		return search.search_Count(map);
	}

	@Override
	public List<boardVO> search_Notice(String board_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<boardVO> search_Count_Notice(String board_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<boardVO> search_Up(int page, searchVO searchVO, String hotcount) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		int startNum = (page-1)*10+1;
		int endNum = page*10;
		
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		map.put("searchVO", searchVO);
		map.put("hotcount", hotcount);
		
		return search.search_Up(map);
	}

	@Override
	public int search_Count_Up(searchVO searchVO, String hotcount) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("searchVO", searchVO);
		map.put("hotcount", hotcount);
		
		return search.search_Count_Up(map);
	}

	@Override
	public List<boardVO> search_Down(int page, searchVO searchVO, String hotcount) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		int startNum = (page-1)*10+1;
		int endNum = page*10;
		
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		map.put("searchVO", searchVO);
		map.put("hotcount", hotcount);
		
		return search.search_Down(map);
	}

	@Override
	public int search_Count_Down(searchVO searchVO, String hotcount) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("searchVO", searchVO);
		map.put("hotcount", hotcount);
		
		return search.search_Count_Down(map);
	}

	@Override
	public List<boardVO> search_Report(int page, searchVO searchVO) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		int startNum = (page-1)*10+1;
		int endNum = page*10;
		
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		map.put("searchVO", searchVO);
		
		return search.search_Report(map);
	}

	@Override
	public int search_Count_Report(searchVO searchVO) {
		return search.search_Count_Report(searchVO);
	}

	@Override
	public List<boardVO> search_Total(int page, searchVO searchVO) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		int startNum = (page-1)*10+1;
		int endNum = page*10;
		
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		map.put("searchVO", searchVO);
		
		return search.search_Total(map);
	}

	@Override
	public int search_Count_Total(searchVO searchVO) {
		return search.search_Count_Total(searchVO);
	}

	@Override
	public List<userVO> search_User(int page, searchVO searchVO) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		int startNum = (page-1)*10+1;
		int endNum = page*10;
		
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		map.put("searchVO", searchVO);
		
		return search.search_User(map);
	}

	@Override
	public int search_Count_User(searchVO searchVO) {
		return search.search_Count_User(searchVO);
	}

	
	



}
