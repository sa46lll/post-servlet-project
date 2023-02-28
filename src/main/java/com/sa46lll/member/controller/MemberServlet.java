package com.sa46lll.member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sa46lll.member.service.MemberService;
import com.sa46lll.member.vo.MemberVo;
import com.sa46lll.post.service.PostService;
import com.sa46lll.post.vo.PostVo;

@WebServlet("/login")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MemberServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		// 로그인
		String id = request.getParameter("userId");
		String password = request.getParameter("userPw");

		MemberService memberService = new MemberService();
		MemberVo member = memberService.login(new MemberVo(id, password));
		if (member == null) {
			System.out.println("실패");
			response.sendRedirect("./login.html");
			return;
		}

		// 세선에 유저 아이디 저장
		HttpSession session = request.getSession(true);
		session.setAttribute("loginId", id);
		request.setAttribute("member", member);

		RequestDispatcher rd = request.getRequestDispatcher("./login.jsp");
		rd.forward(request, response);
		System.out.println("로그인 성공");
	}

}
