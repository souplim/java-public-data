package com.spring.example.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// @Setter
// @Getter
// @ToString
@NoArgsConstructor // 매개변수 있는 생성자 만들어지면 기본생성자 안 만들어지기 때문에 따로 생성
@AllArgsConstructor
@Data
public class SampleDTO {
	private String name;
	private int age;
}
