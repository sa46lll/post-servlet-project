package com.sa46lll.post.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.sa46lll.mybatis.MyBatisConnectionFactory;
import com.sa46lll.post.dao.PostDao;
import com.sa46lll.post.vo.PostVo;

public class PostService {

	SqlSessionFactory factory = MyBatisConnectionFactory.getSqlSessionFactory();

	public List<PostVo> findAll() {
		SqlSession session = factory.openSession();

		PostDao dao = new PostDao(session);
		List<PostVo> vo = dao.findAll();

		session.close();
		return vo;
	}

	public void save(PostVo postVo) {
		SqlSession session = factory.openSession();

		PostDao dao = new PostDao(session);
		dao.save(postVo);

		session.commit();
		session.close();
	}

	public PostVo findById(Long postId) {
		SqlSession session = factory.openSession();

		PostDao dao = new PostDao(session);
		PostVo vo = dao.findById(postId);

		session.close();
		return vo;
	}

	public void increaseLikeCount(Long postId) {
		SqlSession session = factory.openSession();

		PostDao dao = new PostDao(session);
		dao.increaseLikeCount(postId);
		
		session.commit();
		session.close();	
	}

	public void decreaseLikeCount(Long postId) {
		SqlSession session = factory.openSession();

		PostDao dao = new PostDao(session);
		dao.decreaseLikeCount(postId);
		
		session.commit();
		session.close();	
	}
}
