package com.sa46lll.like.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sa46lll.like.service.LikeService;
import com.sa46lll.like.vo.LikeVo;
import com.sa46lll.post.service.PostService;

@WebServlet("/posts/like")
public class LikeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LikeServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		LikeService likeService = new LikeService();

		Long postId = Long.parseLong(request.getParameter("postId"));
		HttpSession session = request.getSession(true);
		String memberId = (String) session.getAttribute("loginId");
		
		LikeVo likeVo = new LikeVo(postId, memberId);
		likeService.addLike(likeVo);
		PostService postService = new PostService();
		postService.increaseLikeCount(postId);
	}
}
