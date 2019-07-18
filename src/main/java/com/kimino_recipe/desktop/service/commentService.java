package com.kimino_recipe.desktop.service;

import java.util.List;

import com.kimino_recipe.desktop.domain.commentVO;

public interface commentService {
	
	/*댓글*/
	public int insert_Comment(commentVO commentVO);// 댓글 작성
	public commentVO commentView(String comment_num); //수정할 댓글 정보를 가져옴
	public void update_Comment(commentVO commentVO, String comment_num); //댓글 수정 업데이트
	public int delete_Comment(String comment_num); //댓글삭제
	public void update_CommentCount(int commentCount, String board_num); // 댓글 쓰기, 삭제 때마다  갱신
	public List<commentVO> select_Comment(String board_num); // 해당글에 작성된 댓글 검색
	public int get_CommentCount(String board_num); // 해당 게시글에 몇개의 댓글이 달렸는지 검색
	
}
