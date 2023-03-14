package com.spring.admin.login.vo;

import lombok.Data;

@Data
public class AdminLoginVO {
	private String a_id;		// 관리자 아이디
	private String a_pwd;		// 관리자 비밀번호
	private String a_name;		// 관리자 이름
	private String a_phone;		// 관리자 핸드폰번호
	private String a_email;		// 관리자 이메일
	private String a_date;		// 관리자 등록일
}