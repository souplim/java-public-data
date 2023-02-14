package com.spring.persistence;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

import lombok.extern.log4j.Log4j;

/* JUnit�� ���� �׽�Ʈ�� ���� �����ӿ�ũ�� �ڹ� �� ������� ���ߵǾ���
 * ���� �׽�Ʈ�� �����ڰ� �ǵ��� ��� Ư�� �ڵ� ����(unit)�� ����� �����ϴ����� �����ϱ� ���� �����ϴ� �׽�Ʈ
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
			log.info("�����ͺ��̽��� ���������� ����Ǿ����ϴ�.");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
