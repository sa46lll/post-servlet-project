package com.sa46lll.like.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LikeVo {
	private Long id;
	private Long postId;
	private String memberId;
	
	public LikeVo(Long postId, String memberId) {
		this.postId = postId;
		this.memberId = memberId;
	}
}
