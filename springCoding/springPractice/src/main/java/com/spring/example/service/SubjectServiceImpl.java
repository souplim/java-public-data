package com.spring.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.example.domain.SubjectVO;
import com.spring.mapper.ExampleMapper;

import lombok.Setter;

@Service // DAO(Mapper)���� �޾ƿ� �� ���
public class SubjectServiceImpl implements SubjectService {
	
	@Setter(onMethod_ = @Autowired)
	private ExampleMapper exampleMapper; // dao�� �������̽� ����Ŭ���� �ν��Ͻ� ���� 
	
	@Override
	public List<SubjectVO> subjectList(int no){
		List<SubjectVO> subjectList = exampleMapper.getSubjectList(no); // no���� ū ������ �����Ͷ�
		return subjectList;
	}
	
	@Override
	public int subjectInsert(SubjectVO subject) {
		int result = exampleMapper.subjectInsert(subject);
		return result;
	}

	@Override
	public int subjectUpdate(SubjectVO subject) {
		int result = exampleMapper.subjectUpdate(subject);
		return result;
	}

	@Override
	public int subjectDelete(int no) {
		int result = exampleMapper.subjectDelete(no);
		return result;
	}

	@Override
	public String getSubjectName(String s_num) {
		String result = exampleMapper.getSubjectName(s_num);
		return result;
	}
}
