package com.sa46lll.post.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.sa46lll.post.vo.PostVo;

public class PostDao {
	private SqlSession session = null;

	public PostDao() {
	}

	public PostDao(SqlSession session) {
		this.session = session;
	}

	public List<PostVo> findAll() {
		List<PostVo> vo = session.selectList("dashboard.post.selectAll");
		return vo;
	}

	public void save(PostVo postVo) {
		session.insert("dashboard.post.insert", postVo);
	}

	public PostVo findById(Long postId) {
		PostVo vo = session.selectOne("dashboard.post.selectOne", postId);
		return vo;
	}

	public void increaseLikeCount(Long postId) {
		session.update("dashboard.post.updateLikeCount", postId);
	}

	public void decreaseLikeCount(Long postId) {
		session.update("dashboard.post.decreaseLikeCount", postId);
	}
}
