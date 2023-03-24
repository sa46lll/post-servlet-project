package com.sa46lll.like.service;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.sa46lll.like.dao.LikeDao;
import com.sa46lll.like.vo.LikeVo;
import com.sa46lll.mybatis.MyBatisConnectionFactory;

public class LikeService {
	
	SqlSessionFactory factory = MyBatisConnectionFactory.getSqlSessionFactory();

	public boolean isLiked(LikeVo likeVo) {
		SqlSession session = factory.openSession();

		LikeDao dao = new LikeDao(session);
		LikeVo vo = dao.existsByPostIdAndMemberId(likeVo);

		session.close();
		return vo != null;
	}

	public void addLike(LikeVo likeVo) {
		SqlSession session = factory.openSession();

		LikeDao dao = new LikeDao(session);
		dao.insert(likeVo);

		session.commit();
		session.close();
	}

	public void deleteLike(LikeVo likeVo) {
		SqlSession session = factory.openSession();

		LikeDao dao = new LikeDao(session);
		dao.delete(likeVo);

		session.commit();
		session.close();
	}
}
