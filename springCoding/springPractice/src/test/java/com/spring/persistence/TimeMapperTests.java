package com.spring.persistence;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.mapper.TimeMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

/* JUnit 프레임워크의 테스트 실행 방법을 확장할 때 사용하는 어노테이션.
 * Runner 클래스를 설정하면 JUnit에 내장된 Runner 대신 그 클래스를 실행.
 * JUnit이 테스트를 진행하는 중 테스트가 사용할 어플리케이션 컨텍스트를 만들고 관리하는 작업을 해줌.
 * */
@RunWith(SpringJUnit4ClassRunner.class)
/* 자동으로 만들어줄 어플리케이션 컨텍스트의 설정파일의 위치를 지정할 때 사용 */
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class TimeMapperTests {

	@Setter(onMethod_ = @Autowired)
	private TimeMapper timeMapper;
	
	@Test
	public void testGetTime() {
		log.info("timeMapper 인터페이스로 구현된 구현 클래스명");
		log.info(timeMapper.getClass().getName());
		log.info("-------------------------------");
		log.info("getTime() 메서드 실행");
		log.info(timeMapper.getTime());
		
		log.info("-------------------------------");
		log.info("getTime2() 메서드 실행");
		log.info(timeMapper.getTime2());
	}
}
