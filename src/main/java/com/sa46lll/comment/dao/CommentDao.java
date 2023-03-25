package com.sa46lll.comment.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.sa46lll.comment.vo.CommentVo;

public class CommentDao {
	
	private SqlSession session = null;

	public CommentDao(SqlSession session) {
		this.session = session;
	}

	public List<CommentVo> selectAllByPostId(Long postId) {
		return session.selectList("dashboard.comment.selectAllByPostId", postId);
	}

	public void insert(CommentVo vo) {
		session.insert("dashboard.comment.insert", vo);
	}

}
