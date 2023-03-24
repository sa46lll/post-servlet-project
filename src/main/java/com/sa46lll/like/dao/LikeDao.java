package com.sa46lll.like.dao;

import org.apache.ibatis.session.SqlSession;

import com.sa46lll.like.vo.LikeVo;

public class LikeDao {
	
	private SqlSession session = null;

	public LikeDao() {
	}

	public LikeDao(SqlSession session) {
		this.session = session;
	}

	public LikeVo existsByPostIdAndMemberId(LikeVo likeVo) {
		return session.selectOne("dashboard.like.selectByPostIdAndMemberId", likeVo);
	}

	public void insert(LikeVo likeVo) {
		session.insert("dashboard.like.insert", likeVo);
	}

	public void delete(LikeVo likeVo) {
		session.delete("dashboard.like.delete", likeVo);
	}
}
