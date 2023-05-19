package com.spring.client.example.domain;

import java.util.List;

import lombok.Data;

@Data
public class StudentDTO {
	private int no;
	private String name;
	private int id; 				// 학번
	private int age;
	private String gender;			// 성별
	private Grade grade;			// 학년
	private Boolean isAttending;	// 재학 여부
	private List<String> clubs;		// 참여 활동
	private String major;			// 전공
}
