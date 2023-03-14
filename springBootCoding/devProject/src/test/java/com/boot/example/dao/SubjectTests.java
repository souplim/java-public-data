package com.boot.example.dao;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.boot.example.domain.SubjectVO;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class SubjectTests {
	
	@Setter(onMethod_ = @Autowired)
	private SubjectDAO subjectDAO; // mybatis가 자동으로 만들어준 SubjectDAO 인터페이스의 구현클래스의 인스턴스 주입
	
	/* @Test
	public void testSubjectInsert() {
		log.info("------------------------------");
		log.info("subjectInsert() 메서드 실행");
		SubjectVO svo = new SubjectVO();
		svo.setS_num("06");
		svo.setS_name("물리학과");
		log.info(exampleMapper.subjectInsert(svo));
	} */
	
	/* @Test
	public void testSubjectUpdate() {
		log.info("------------------------------");
		log.info("subjectUpdate() 메서드 실행");
		SubjectVO svo = new SubjectVO();
		svo.setS_name("경영학과");
		svo.setNo(30);
		log.info(exampleMapper.subjectUpdate(svo));
	} */
	
	/* @Test
	public void testSubjectDelete() {
		log.info("------------------------------");
		log.info("subjectDelete() 메서드 실행");
		log.info(exampleMapper.subjectDelete(24));
	} */
	
	
	@Test
	public void testSubjectList() {
		log.info("------------------------------");
		log.info("getSubjectList() 메서드 실행");
		List<SubjectVO> list = subjectDAO.getSubjectList(0); // no가 0보다 큰 데이터 가져와라
		for(SubjectVO vo : list)
			log.info(vo.toString());
	}
	
	/* @Test
	public void testSubjectName() { // JUnit으로 확인
		log.info("------------------------------");
		log.info("getSubjectName() 메서드 실행");
		log.info(exampleMapper.getSubjectName("01"));
	} */
}
