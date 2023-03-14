package com.boot.example.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // 설정자, 접근자, toString(), hashCode(), 기본생성자
@AllArgsConstructor // 매개변수 있는 생성자
@NoArgsConstructor  // 매개변수 있는 생성자 만들면 @Data에서 기본생성자 안 만들어지므로 추가
public class SubjectVO {
	private int no;
	private String s_num;
	private String s_name;
}
