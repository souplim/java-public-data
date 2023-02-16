package com.spring.mapper;

import java.util.List;

import com.spring.example.domain.SubjectVO;

public interface ExampleMapper {

	public List<SubjectVO> getSubjectList(int no);
	
	public int subjectInsert(SubjectVO subject);
	
	public int subjectUpdate(SubjectVO subject);
	
	public int subjectDelete(int no);
	
	public String getSubjectName(String s_num); /* 학과번호를 인자로 학과명을 출력 */
}
