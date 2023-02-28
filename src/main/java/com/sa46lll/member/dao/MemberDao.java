package com.sa46lll.member.dao;

import org.apache.ibatis.session.SqlSession;

import com.sa46lll.member.vo.MemberVo;

public class MemberDao {
	
	private SqlSession session = null;

	public MemberDao() {

	}

	public MemberDao(SqlSession session) {
		this.session = session;
	}

	public MemberVo selectByMemberIdAndMemberPw(MemberVo param) {
		MemberVo vo = session.selectOne("dashboard.member.selectByMemberIdAndMemberPw", param);
		return vo;
	}
}
