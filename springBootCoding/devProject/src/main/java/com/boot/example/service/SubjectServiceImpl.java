package com.boot.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.example.dao.SubjectDAO;
import com.boot.example.domain.SubjectVO;
//import com.boot.example.mapper.ExampleMapper;

import lombok.Setter;

@Service
public class SubjectServiceImpl implements SubjectService {
	
	@Setter(onMethod_ = @Autowired)
//	private ExampleMapper exampleMapper; // dao의 인터페이스 구현클래스 인스턴스 주입 
	private SubjectDAO subjectDAO;
	
	@Override
	public List<SubjectVO> subjectList(int no){
		List<SubjectVO> subjectList = subjectDAO.getSubjectList(no); // no보다 큰 데이터 가져와라
		return subjectList;
	}
	
	@Override
	public int subjectInsert(SubjectVO subject) {
		int result = subjectDAO.subjectInsert(subject);
		return result;
	}

	@Override
	public int subjectUpdate(SubjectVO subject) {
		int result = subjectDAO.subjectUpdate(subject);
		return result;
	}

	@Override
	public int subjectDelete(int no) {
		int result = subjectDAO.subjectDelete(no);
		return result;
	}

	@Override
	public String getSubjectName(String s_num) {
		String result = subjectDAO.getSubjectName(s_num);
		return result;
	}
}
