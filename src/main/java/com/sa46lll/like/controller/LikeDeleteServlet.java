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

@WebServlet("/posts/like/delete")
public class LikeDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public LikeDeleteServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long postId = Long.parseLong(request.getParameter("postId"));
		
		LikeService likeService = new LikeService();
		
		HttpSession session = request.getSession(true);
		String memberId = (String) session.getAttribute("loginId");
		
		LikeVo likeVo = new LikeVo(postId, memberId);
		likeService.deleteLike(likeVo);
		PostService postService = new PostService();
		postService.decreaseLikeCount(postId);
	}

}
