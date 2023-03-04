package com.sa46lll.post.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sa46lll.like.service.LikeService;
import com.sa46lll.like.vo.LikeVo;
import com.sa46lll.post.service.PostService;
import com.sa46lll.post.vo.PostVo;

@WebServlet("/posts/detail")
public class PostDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PostDetailServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		String memberId = (String) session.getAttribute("loginId");
		
		Long postId = Long.parseLong(request.getParameter("postId"));
		PostService postService = new PostService();
		PostVo post = postService.findById(postId);
		request.setAttribute("post", post);
		
		LikeVo likeVo = new LikeVo(postId, memberId);
		LikeService likeService = new LikeService();
		boolean isLiked = likeService.isLiked(likeVo);
		request.setAttribute("isLiked", isLiked);
		System.out.println(isLiked);
		
		RequestDispatcher rd = request.getRequestDispatcher("../post-detail.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
