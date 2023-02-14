package com.spring.persistence;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

import lombok.extern.log4j.Log4j;

/* JUnit은 단위 테스트를 위한 프레임워크로 자바 언어를 기반으로 개발되었음
 * 단위 테스트란 개발자가 의도한 대로 특정 코드 단위(unit)가 제대로 동작하는지를 증명하기 위해 수행하는 테스트
 * */
@Log4j
public class JDBCTests {
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testConnection() {
		try(Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xepdb1","javauser","java1234")){
			log.info(conn);
			log.info("-----------------------------");
			log.info("데이터베이스에 정상적으로 연결되었습니다.");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
