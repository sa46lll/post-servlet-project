package com.sa46lll.comment.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sa46lll.comment.service.CommentService;
import com.sa46lll.comment.vo.CommentVo;

@WebServlet("/posts/comments")
public class CommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CommentServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		String memberId = (String) session.getAttribute("loginId");
		
		String content = request.getParameter("content");
		Long postId = Long.parseLong(request.getParameter("postId"));
		
		CommentVo comment = new CommentVo(content, postId, memberId);
		CommentService commentService = new CommentService();
		commentService.addComment(comment);
	}

}
