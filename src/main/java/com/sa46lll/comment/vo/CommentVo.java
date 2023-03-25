package com.sa46lll.comment.vo;

import java.sql.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CommentVo {
	private Long id;
	private String content;
	private Date createdAt;
	private Long postId;
	private String memberId;

	public CommentVo(String content, Long postId, String memberId) {
		this.content = content;
		this.postId = postId;
		this.memberId = memberId;
	}
}
