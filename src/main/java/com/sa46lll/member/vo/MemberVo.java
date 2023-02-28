package com.sa46lll.member.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MemberVo {
	private String id;
	private String password;
	private String username;
	
	public MemberVo(String id, String password) {
		this.id = id;
		this.password = password;
	}
}
