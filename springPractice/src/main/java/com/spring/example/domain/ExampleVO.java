package com.spring.example.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@Data
@Setter
@Getter
@NoArgsConstructor // 매개변수 있는 생성자 만들어지면 기본생성자 안 만들어지기 때문에 따로 생성
@AllArgsConstructor
@ToString
public class ExampleVO {
	
	private Integer no;
	private String name;
	private String phone;
	
}
