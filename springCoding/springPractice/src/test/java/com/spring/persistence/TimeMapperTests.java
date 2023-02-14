package com.spring.persistence;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.mapper.TimeMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

/* JUnit �����ӿ�ũ�� �׽�Ʈ ���� ����� Ȯ���� �� ����ϴ� ������̼�.
 * Runner Ŭ������ �����ϸ� JUnit�� ����� Runner ��� �� Ŭ������ ����.
 * JUnit�� �׽�Ʈ�� �����ϴ� �� �׽�Ʈ�� ����� ���ø����̼� ���ؽ�Ʈ�� ����� �����ϴ� �۾��� ����.
 * */
@RunWith(SpringJUnit4ClassRunner.class)
/* �ڵ����� ������� ���ø����̼� ���ؽ�Ʈ�� ���������� ��ġ�� ������ �� ��� */
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class TimeMapperTests {

	@Setter(onMethod_ = @Autowired)
	private TimeMapper timeMapper;
	
	@Test
	public void testGetTime() {
		log.info("timeMapper �������̽��� ������ ���� Ŭ������");
		log.info(timeMapper.getClass().getName());
		log.info("-------------------------------");
		log.info("getTime() �޼��� ����");
		log.info(timeMapper.getTime());
		
		log.info("-------------------------------");
		log.info("getTime2() �޼��� ����");
		log.info(timeMapper.getTime2());
	}
}
