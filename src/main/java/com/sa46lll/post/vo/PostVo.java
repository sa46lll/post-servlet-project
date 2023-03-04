package com.sa46lll.post.vo;

import java.sql.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PostVo {
	private Long id;
	private String title;
	private String content;
	private Date createdAt;
	private String memberId;
	private int likeCount;
	
	public PostVo(String title, String content, String memberId) {
		this.title = title;
		this.content = content;
		this.memberId = memberId;
	}
}
