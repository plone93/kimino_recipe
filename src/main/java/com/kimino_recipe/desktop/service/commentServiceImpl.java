package com.kimino_recipe.desktop.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.kimino_recipe.desktop.domain.commentVO;
import com.kimino_recipe.desktop.mapper.commentMapper;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class commentServiceImpl implements commentService {
	
	commentMapper comment;
	
	@Override
	public int insert_Comment(commentVO commentVO) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("commentVO", commentVO);	
		return comment.insert_Comment(map);
	}

	@Override
	public commentVO commentView(String comment_num) {
		return comment.commentView(comment_num);
	}

	@Override
	public void update_Comment(commentVO commentVO, String comment_num) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("commentVO", commentVO);
		map.put("comment_num", comment_num);
		
		comment.update_Comment(map);
	}

	@Override
	public int delete_Comment(String comment_num) {
		return comment.delete_Comment(comment_num);
	}

	@Override
	public void update_CommentCount(int commentCount, String board_num) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("commentCount", commentCount);
		map.put("board_num", board_num);
		
		comment.update_CommentCount(map);		
	}

	@Override
	public List<commentVO> select_Comment(String board_num) {
		return comment.select_Comment(board_num);
	}

	@Override
	public int get_CommentCount(String board_num) {
		return comment.get_CommentCount(board_num);
	}
	
	
}
