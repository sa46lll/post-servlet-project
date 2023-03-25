/**
 * 코멘트 생성, 삭제
 */

function addComment() {
	var newComment = {
		postId: $('#post-id').val(),
		content: $('#comment-input').val(),
		memberId: $('#member-id').val(),
		createdAt: "2023-04-26",
	};
	$.ajax({
		url: 'http://localhost:8080/dashboard/posts/comments',
		type: 'POST',
		data: {
			postId: newComment.postId,
			content: newComment.content,
		},
		success: function(data) {
			let html = $('<div class="d-flex flex-row mb-2">' +
				'<img src="https://i.imgur.com/9AZ2QX1.jpg" width="40" class="rounded-image">' +
				'<div class="d-flex flex-column ml-2">' +
				'<span class="name">' + newComment.memberId + '</span> <small class="comment-text">' + newComment.content + '</small>' +
				'<div class="d-flex flex-row align-items-center status">' +
				'<small>' + newComment.createdAt + '</small>' +
				'</div>' +
				'</div>' +
				'</div>');
			$('.comments').append(html);
			$('#comment-input').val('');
		},
		error: function() {
			alert("댓글 생성 실패");
			console.log('에러 발생');
		}
	})
}