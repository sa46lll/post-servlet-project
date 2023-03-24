/**
 * 좋아요, 좋아요 취소
 */

function cancelLikePost(postId) {
	var getPostId = postId;
	
	$.ajax({
		url: 'http://localhost:8080/dashboard/posts/like/delete',
		type: 'POST',
		data: {
			postId: postId
		},
		success: function(data) {
			alert("좋아요 취소 성공");
			console.log("좋아요 취소");
			console.log("data : " + data);
			console.log("data : " + data.postId);
			var icon = $('<i>').addClass('fa fa-heart-o').css('color', 'red');
			
             var button = $('<button>').attr({
                'type': 'submit',
                'id' : 'likeButton',
                'style': 'border: none; background: none; color: gray',
                'onclick': 'likePost(' + getPostId + ')'
            }).append(icon);
            $('#likeButton').replaceWith(button);
		},
		error: function() {
			alert("좋아요 취소 실패");
			console.log('에러 발생');
		}
	})
}

function likePost(postId) {
	var getPostId = postId;
	
	$.ajax({
		url: 'http://localhost:8080/dashboard/posts/like',
		type: 'POST',
		data: {
			postId: postId
		},
		success: function(data) {
			alert("좋아요 성공");
			console.log("data : " + data);
			console.log("data : " + data.postId);
			var icon = $('<i>').addClass('fa fa-heart');
			
             var button = $('<button>').attr({
                'type': 'submit',
                'id' : 'likeButton',
                'style': 'border: none; background: none; color: gray',
                'onclick': 'cancelLikePost(' + getPostId + ')'
            }).append(icon);
            $('#likeButton').replaceWith(button);
		},
		error: function() {
			alert("좋아요 실패");
			console.log('에러 발생');
		}
	})
}
