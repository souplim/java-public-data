package com.boot.example.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.boot.example.domain.SubjectVO;

@Mapper
public interface SubjectDAO {
	public List<SubjectVO> getSubjectList(int no);
	public String getSubjectName(String s_num); /* 학과번호를 인자로 학과명을 출력 */
	public int subjectInsert(SubjectVO subject);
	public int subjectUpdate(SubjectVO subject);
	public int subjectDelete(int no);
}
