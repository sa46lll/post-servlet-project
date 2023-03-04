package com.sa46lll.post.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sa46lll.post.service.PostService;
import com.sa46lll.post.vo.PostVo;

@WebServlet("/posts")
public class PostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PostServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		String memberId = (String) session.getAttribute("loginId");
		request.setAttribute("now", LocalDate.now());
		request.setAttribute("memberId", memberId);
		
		RequestDispatcher rd = request.getRequestDispatcher("./post-create.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession(true);
		String memberId = (String) session.getAttribute("loginId");

		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		PostVo postVo = new PostVo(title, content, memberId);
		PostService postService = new PostService();
		postService.save(postVo);
		
		List<PostVo> posts = postService.findAll();
		request.setAttribute("posts", posts);
		
		RequestDispatcher rd = request.getRequestDispatcher("./login.jsp");
		rd.forward(request, response);
	}

}
