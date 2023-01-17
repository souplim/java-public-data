package com.jdbc;

import java.util.ArrayList;

import com.subject.SubjectDAO;
import com.subject.SubjectVO;

public class SubjectService {
	private static SubjectService instance = null;
	
	private SubjectService() {}
	
	public static SubjectService getInstance() {
		if(instance == null) {
			instance = new SubjectService();
		}
		return instance;
	}
	
	public ArrayList<SubjectVO> subjectList(SubjectVO vo){
		ArrayList<SubjectVO> list = new SubjectDAO().getSubjectTotal(vo);
		return list;
	}
	
	public boolean subjectInsert(SubjectVO vo) {
		boolean result = new SubjectDAO().subjectInsert(vo);
		return result;
	}
}
