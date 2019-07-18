package com.kimino_recipe.desktop.mapper;

import java.util.HashMap;
import java.util.List;

import com.kimino_recipe.desktop.domain.commentVO;

public interface commentMapper {
	
	/*댓글*/
	public int insert_Comment(HashMap<String, Object> map);// 댓글 작성
	public commentVO commentView(String comment_num); //수정할 댓글 정보를 가져옴
	public void update_Comment(HashMap<String, Object> map); //댓글 수정 업데이트
	public int delete_Comment(String comment_num); //댓글삭제
	public void update_CommentCount(HashMap<String, Object> map); // 댓글 쓰기, 삭제 때마다  갱신
	public List<commentVO> select_Comment(String board_num); // 해당글에 작성된 댓글 검색
	public int get_CommentCount(String board_num); // 해당글)몇개의 댓글이 작성됬는지 검색
}
