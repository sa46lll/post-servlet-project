package com.sa46lll.member.service;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.sa46lll.member.dao.MemberDao;
import com.sa46lll.member.vo.MemberVo;
import com.sa46lll.mybatis.MyBatisConnectionFactory;

public class MemberService {
	
	SqlSessionFactory factory = MyBatisConnectionFactory.getSqlSessionFactory();

	public MemberVo login(MemberVo param) {
		SqlSession session = factory.openSession();
		MemberDao dao = new MemberDao(session);
		MemberVo vo = dao.selectByMemberIdAndMemberPw(param);
		session.close();
		return vo;
	}
}
