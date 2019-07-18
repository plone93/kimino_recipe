package com.kimino_recipe.desktop.service;

import java.util.List;

import com.kimino_recipe.desktop.domain.boardVO;
import com.kimino_recipe.desktop.domain.countVO;
import com.kimino_recipe.desktop.domain.userVO;

public interface boardService {
	

	/*기능*/
	public boardVO boardView(String board_num); // 클릭한 게시글 검색
	public String select_UserName(String board_num); //게시글의 이름을 가져옴
	public void update_ReadCount(String board_num); //클릭시 조회수 증가
	public void update_UpCount(String board_num); // 추천
	public void update_DownCount(String board_num); //비추천
	public void update_ReportCount(String board_num); // 신고
	public int get_ReadCount(String board_num); //조회수를 가져옴
	public countVO get_TotalCount(String board_num); // 추천, 비추천 카운트를 가져옴
	public int delete_Board(String board_num); // 글삭제
	public int insert_Board(boardVO boardVO, String board_id); //글 작성
	public int update_Board(boardVO boardVO, String board_num); // 글 수정 

	
	/*기본게시판*/
	public List<boardVO> select_AllBoard(int page, String board_id); //모든 게시글 검색
	public int get_BoardCount(String board_id); // 해당 게시판에 몇개의 게시글이 작성됐는지 검색
	
	/*추천  게시판*/
	public List<boardVO> select_AllBoard_Up(int page, String board_id, String hotcount); // 추천,비추천 게시판 리스트  가져옴
	public int get_BoardCount_Up(String board_id, String hotcount); //추천,비추천 게시판에 몇개의 글이 있는지 검색
	
	/*비추천 게시판*/
	public List<boardVO> select_AllBoard_Down(int page, String board_id, String hotcount); // 추천,비추천 게시판 리스트  가져옴
	public int get_BoardCount_Down(String board_id, String hotcount); //추천,비추천 게시판에 몇개의 글이 있는지 검색
	
	/*통합 게시판*/
	public List<boardVO> select_AllBoard_Total(int page, String board_id); // 비추천게시판 리스트  가져옴
	public int get_BoardCount_Total(String board_id); //통합게시판에 몇개의 글이 있는지 검색
	
	/*신고 게시판*/
	public List<boardVO> select_AllBoard_Report(int page, String board_id, String word); // 신고게시판 검색
	public int get_BoardCount_Report(String board_id, String word); //신고게시판에 몇개의 글이 있는지 검색

	/*공지사항 게시판*/
	public List<boardVO> select_AllBoard_Notice(int page, String board_id); //공지사항검색
	public int get_BoardCount_Notice(String board_id); //공지사항게시판에 몇개의 글이 있는지 검색
	
	/*회원관리 게시판*/
	public List<userVO> select_AllBoard_User(int page); // 회원관리게시판에 몇개의 계정이 있는지 검색
	public int get_UserCount(); //몇명의 회원이 있는지 검색

}
