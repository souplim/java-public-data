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
	private ExampleMapper exampleMapper; // mybatis�� �ڵ����� ������� ExampleMapper �������̽��� ����Ŭ������ �ν��Ͻ� ����
	
	@Test
	public void testSubjectList() {
		log.info("------------------------------");
		log.info("getSubjectList() �޼��� ����");
		List<SubjectVO> list = exampleMapper.getSubjectList(0); // no�� 0���� ū ������ �����Ͷ�
		for(SubjectVO vo : list)
			log.info(vo);
	}
	
}
