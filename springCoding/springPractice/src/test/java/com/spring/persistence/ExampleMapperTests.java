package com.spring.persistence;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.example.domain.SubjectVO;
import com.spring.mapper.ExampleMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ExampleMapperTests {

	@Setter(onMethod_ = @Autowired)
	private ExampleMapper exampleMapper; // mybatis가 자동으로 만들어준 ExampleMapper 인터페이스의 구현클래스의 인스턴스 주입
	
	@Test
	public void testSubjectList() {
		log.info("------------------------------");
		log.info("getSubjectList() 메서드 실행");
		List<SubjectVO> list = exampleMapper.getSubjectList(0); // no가 0보다 큰 데이터 가져와라
		for(SubjectVO vo : list)
			log.info(vo);
	}
	
}
