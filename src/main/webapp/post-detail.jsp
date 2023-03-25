<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 상세보기</title>
<!-- jQuery CDN -->
<script src="https://code.jquery.com/jquery-3.6.4.min.js"
	integrity="sha256-oP6HI9z1XaZNBrJURtCoUT5SUnxFr8s3BzRl+cbzUq8="
	crossorigin="anonymous"></script>
<script src="../js/postLike.js"></script>
<script src="../js/comment.js"></script>
<link href="../css/post-detail.css" rel="stylesheet">
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<div class="row d-flex justify-content-center">
		<div class="container mt-5 mb-5"
			style="display: flex; justify-content: center">
			<div class="row d-flex align-items-center justify-content-center">
				<div class="col-md-6">
					<div class="card">
						<div class="d-flex justify-content-between p-2 px-3">
							<div class="d-flex flex-row align-items-center">
								<div class="d-flex flex-column ml-2">
									<span class="font-weight-bold"> 제목 : ${post.getTitle()}
									</span> <small class="text-primary"> <i class="fa fa-user"></i>
										작성자 : ${post.getMemberId()}
									</small>
								</div>
							</div>
							<div class="d-flex flex-row mt-1 ellipsis">
								<small class="mr-2">20 mins</small> <i class="fa fa-ellipsis-h"></i>
							</div>
						</div>
						<!-- <img src="https://i.imgur.com/xhzhaGA.jpg" class="img-fluid"> -->
						<div class="p-2">
							<div class="container" style="min-height: 100px">
								<p class="text-justify">${post.getContent()}</p>
							</div>
							<hr>
							<div class="d-flex justify-content-between align-items-center">
								<div class="d-flex flex-row icons d-flex align-items-center">
									<c:choose>
										<c:when test="${ isLiked }">
											<i id="likeButton" class="fa fa-heart"
												onclick="cancelLikePost(${post.getId()})"></i>
										</c:when>
										<c:otherwise>
											<i id="likeButton" class="fa fa-heart-o"
												onclick="likePost(${post.getId()})" style="color: red"></i>
										</c:otherwise>
									</c:choose>
									<!-- <i class="fa fa-heart"></i>  -->
									<i class="fa fa-smile-o ml-2"></i>
								</div>
								<div class="d-flex flex-row muted-color">
									<span>2 comments</span> <span class="ml-2">Share</span>
								</div>
							</div>
							<hr>
							<div class="comments">

								<!-- 여기서 부터 반복  -->
								<c:forEach var="comment" items="${ comments }">
									<div class="d-flex flex-row mb-2">
										<img src="https://i.imgur.com/9AZ2QX1.jpg" width="40"
											class="rounded-image">
										<div class="d-flex flex-column ml-2">
											<span class="name">${ comment.getMemberId() }</span> <small
												class="comment-text">${ comment.getContent() }</small>
											<div class="d-flex flex-row align-items-center status">
												<!-- <small>Like</small> <small>Reply</small> <small>Translate</small> -->
												<small>${ comment.getCreatedAt() }</small>
											</div>
										</div>
									</div>
								</c:forEach>
							</div>


							<div class="comment-input">
								<input type="text" id="comment-input" class="form-control">
								<input type="hidden" id="post-id" name="postId"
									value="${ post.getId() }">
								<input type="hidden"
									id="member-id" name="memberId" value="<%= session.getAttribute("loginId") %>">
								<div class="fonts">
									<button type="submit" onclick="addComment()"
										style="border: none; background: none; color: gray">
										<i class="fa fa-reply"></i>
									</button>
								</div>
							</div>
						</div>
						<div class="row d-flex justify-content-center">
							<div class="col-3 d-flex justify-content-center">
								<button type="button" class="btn" onclick="list"
									style="border: 1px solid #a09c9c; color: #a09c9c">돌아가기</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>