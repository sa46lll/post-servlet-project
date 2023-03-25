package com.sa46lll.comment.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.sa46lll.comment.dao.CommentDao;
import com.sa46lll.comment.vo.CommentVo;
import com.sa46lll.mybatis.MyBatisConnectionFactory;

public class CommentService {

	private static SqlSessionFactory sqlSessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();

	public List<CommentVo> findAllByPostId(Long postId) {
		SqlSession session = sqlSessionFactory.openSession();

		CommentDao dao = new CommentDao(session);
		List<CommentVo> vo = dao.selectAllByPostId(postId);
		
		session.close();
		return vo;
	}

	public void addComment(CommentVo vo) {
		SqlSession session = sqlSessionFactory.openSession();

		CommentDao dao = new CommentDao(session);
		dao.insert(vo);
		
		session.commit();
		session.close();
	}
}
