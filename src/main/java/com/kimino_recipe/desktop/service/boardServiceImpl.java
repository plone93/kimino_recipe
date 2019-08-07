package com.kimino_recipe.desktop.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.kimino_recipe.desktop.domain.boardVO;
import com.kimino_recipe.desktop.domain.countVO;
import com.kimino_recipe.desktop.domain.orderVO;
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
	public String select_Writer(String board_num) {
		return board.select_Writer(board_num);
	}
	
	
	/*기능 끝*/

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
	public List<boardVO> select_AllBoard_Report(int page) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		int startNum = (page-1)*10+1;
		int endNum = page*10;
		
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		
		return board.select_AllBoard_Report(map);
	}

	@Override
	public int get_BoardCount_Report() {
		return board.get_BoardCount_Report();
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

	@Override
	public List<boardVO> select_Season_Up(int page, String board_id1, String board_id2, String board_id3, String board_id4) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		int startNum = (page-1)*10+1;
		int endNum = page*10;
		
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		map.put("board_ida", board_id1);
		map.put("board_idb", board_id2);
		map.put("board_idc", board_id3);
		map.put("board_idd", board_id4);
		
		return board.select_Season_Up(map);
	}

	@Override
	public List<boardVO> select_Country_Up(int page, String board_id11, String board_id22, String board_id33) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		int startNum = (page-1)*10+1;
		int endNum = page*10;
		
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		map.put("board_ida", board_id11);
		map.put("board_idb", board_id22);
		map.put("board_idc", board_id33);
		
		return board.select_Country_Up(map);
	}

	@Override
	public List<boardVO> select_Single_Up(int page, String board_id111) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		int startNum = (page-1)*10+1;
		int endNum = page*10;
		
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		map.put("board_ida", board_id111);
		
		return board.select_Single_Up(map);
	}

	@Override
	public List<boardVO> select_Board_Comment(int page, String board_id) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		int startNum = (page-1)*10+1;
		int endNum = page*10;
		
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		map.put("board_id", board_id);
		
		return board.select_Board_Comment(map);
	}

	@Override
	public List<boardVO> select_Board_ReadCount(int page, String board_id) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		int startNum = (page-1)*10+1;
		int endNum = page*10;
		
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		map.put("board_id", board_id);
		
		return board.select_Board_ReadCount(map);
	}

	@Override
	public List<boardVO> select_Board_Up(int page, String board_id) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		int startNum = (page-1)*10+1;
		int endNum = page*10;
		
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		map.put("board_id", board_id);
		
		return board.select_Board_Up(map);
	}

	@Override
	public List<boardVO> select_Board_Down(int page, String board_id) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		int startNum = (page-1)*10+1;
		int endNum = page*10;
		
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		map.put("board_id", board_id);
		
		return board.select_Board_Down(map);
	}

	@Override
	public List<boardVO> select_MyWriteList(int page, String user_id) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		int startNum = (page-1)*10+1;
		int endNum = page*10;
		
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		map.put("user_id", user_id);
		
		return board.select_MyWriteList(map);
	}

	@Override
	public int select_MyWriteCount(String user_id) {
		return board.select_MyWriteCount(user_id);
	}

	@Override
	public List<orderVO> select_OrderList(int page, String user_id) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		int startNum = (page-1)*10+1;
		int endNum = page*10;
		
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		map.put("user_id", user_id);
		
		return board.select_OrderList(map);
	}

	@Override
	public int select_OrderCount(String user_id) {
		return board.select_OrderCount(user_id);
	}

	@Override
	public List<orderVO> select_AllOrderList(int page) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		int startNum = (page-1)*10+1;
		int endNum = page*10;
		
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		
		return board.select_AllOrderList(map);
	}

	@Override
	public int select_AllOrderCount() {
		return board.select_AllOrderCount();
	}


	
	
	


	
}
