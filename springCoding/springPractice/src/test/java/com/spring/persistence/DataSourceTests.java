package com.spring.persistence;

import java.sql.Connection;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
public class DataSourceTests {
	
	@Setter(onMethod_ = @Autowired)
	private DataSource dataSource;
	
	@Setter(onMethod_ = @Autowired)
	private SqlSessionFactory sqlSessionFactory;
	
	@Test
	public void testConnection() {
		try(Connection conn = dataSource.getConnection()){
			log.info(conn);
			log.info("-------------------------------");
			log.info("����Ŭ �����ͺ��̽��� ���������� ����Ǿ����ϴ�.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testMybatis() {
		// openSession() : SqlSession ��ü�� �����Ѵ�. autoCommit�� false�� �����ȴ�.
		// openSession(boolean autoCommit) : SqlSession ��ü�� �����Ѵ�. autoCommit�� �����ڰ� ������ �� �ִ�.
		
		try(SqlSession session = sqlSessionFactory.openSession(true); // true - �ڵ� Ŀ�� ����
			Connection conn = session.getConnection(); ){
			
			log.info(session);
			log.info(conn);
			log.info("-------------------------------");
			log.info("Mybatis ���� ����");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
