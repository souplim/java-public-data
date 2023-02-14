package com.spring.mapper;

import java.util.List;

import com.spring.example.domain.SubjectVO;

public interface ExampleMapper {

	public List<SubjectVO> getSubjectList(int no);
}
