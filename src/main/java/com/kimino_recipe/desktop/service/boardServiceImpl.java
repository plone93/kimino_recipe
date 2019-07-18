package com.kimino_recipe.desktop.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.kimino_recipe.desktop.domain.boardVO;
import com.kimino_recipe.desktop.domain.countVO;
import com.kimino_recipe.desktop.domain.userVO;
import com.kimino_recipe.desktop.mapper.boardMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class boardServiceImpl implements boardService {
	
	boardMapper board;
	
	@Override
	public boardVO boardView(String board_num) {
		return board.boardView(board_num);
	}

	@Override
	public String select_UserName(String board_num) {
		return board.select_UserName(board_num);
	}

	@Override
	public void update_ReadCount(String board_num) {
		board.update_ReadCount(board_num);
		
	}

	@Override
	public void update_UpCount(String board_num) {
		board.update_UpCount(board_num);
		
	}

	@Override
	public void update_DownCount(String board_num) {
		board.update_DownCount(board_num);
		
	}

	@Override
	public void update_ReportCount(String board_num) {
		board.update_ReportCount(board_num);
		
	}

	@Override
	public int get_ReadCount(String board_num) {
		return board.get_ReadCount(board_num);
	}

	@Override
	public countVO get_TotalCount(String board_num) {
		return board.get_TotalCount(board_num);
	}

	@Override
	public int delete_Board(String board_num) {
		return board.delete_Board(board_num);
	}

	@Override
	public int insert_Board(boardVO boardVO, String board_id) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("boardVO", boardVO);
		map.put("board_id", board_id);
		
		return board.insert_Board(map);
	}

	@Override
	public int update_Board(boardVO boardVO, String board_num) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("boardVO", boardVO);
		map.put("board_num", board_num);
		
		return board.update_Board(map);
	}

	@Override
	public List<boardVO> select_AllBoard(int page, String board_id) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		int startNum = (page-1)*10+1;
		int endNum = page*10;
		
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		map.put("board_id", board_id);
		
		return board.select_AllBoard(map);
	}

	@Override
	public int get_BoardCount(String board_id) {
		return board.get_BoardCount(board_id);
	}

	@Override
	public List<boardVO> select_AllBoard_Up(int page, String board_id, String hotcount) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		int startNum = (page-1)*10+1;
		int endNum = page*10;
		
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		map.put("board_id", board_id);
		map.put("hotcount", hotcount);
		
		return board.select_AllBoard_Up(map);
	}

	@Override
	public int get_BoardCount_Up(String board_id, String hotcount) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("board_id", board_id);
		map.put("hotcount", hotcount);
		
		return board.get_BoardCount_Up(map);
	}

	@Override
	public List<boardVO> select_AllBoard_Down(int page, String board_id, String hotcount) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		int startNum = (page-1)*10+1;
		int endNum = page*10;
		
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		map.put("board_id", board_id);
		map.put("hotcount", hotcount);
		
		return board.select_AllBoard_Down(map);
	}

	@Override
	public int get_BoardCount_Down(String board_id, String hotcount) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("board_id", board_id);
		map.put("hotcount", hotcount);
		
		return board.get_BoardCount_Down(map);
	}

	@Override
	public List<boardVO> select_AllBoard_Total(int page, String board_id) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		int startNum = (page-1)*10+1;
		int endNum = page*10;
		
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		map.put("board_id", board_id);
		
		return board.select_AllBoard_Total(map);
	}

	@Override
	public int get_BoardCount_Total(String board_id) {
		return board.get_BoardCount_Total(board_id);
	}

	@Override
	public List<boardVO> select_AllBoard_Report(int page, String board_id, String word) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		int startNum = (page-1)*10+1;
		int endNum = page*10;
		
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		map.put("board_id", board_id);
		
		return board.select_AllBoard_Report(map);
	}

	@Override
	public int get_BoardCount_Report(String board_id, String word) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("board_id", board_id);
		map.put("word", word);
		
		return board.get_BoardCount_Report(map);
	}

	@Override
	public List<boardVO> select_AllBoard_Notice(int page, String board_id) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		int startNum = (page-1)*10+1;
		int endNum = page*10;
		
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		map.put("board_id", board_id);
		
		return board.select_AllBoard_Notice(map);
	}

	@Override
	public int get_BoardCount_Notice(String board_id) {
		return board.get_BoardCount_Notice(board_id);
	}

	@Override
	public List<userVO> select_AllBoard_User(int page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int get_UserCount() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}
