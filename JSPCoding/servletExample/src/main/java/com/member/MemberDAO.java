package com.member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDAO {
	  // 데이터베이스 연결 관련 상수 선언
	  private static final String JDBC_URL = "jdbc:oracle:thin:@127.0.0.1:1521/xepdb1";
	  private static final String USER = "javauser";
	  private static final String PASSWD = "java1234";
	
	  // 하나의 인스턴스만 가지게 하기 위해 싱글톤으로 생성
	  // 클래스 자신의 타입으로 정적 필드 선언
	  private static MemberDAO instance = null;
	  // 외부에서 호출할 수 있는 정적 메소드인 getInstnace() 선언하여 인스턴스를 반환
	  public static MemberDAO getInstance(){
	      if(instance == null)
	          instance = new MemberDAO();
	      return instance;
	  }
	
	  // 외부에서 new 연산자로 생성자를 호출할 수 없도록 막기 위해 접근제어자 설정
	  private MemberDAO(){
	      try {
	          Class.forName("oracle.jdbc.OracleDriver");
	      } catch(ClassNotFoundException e){
	          e.printStackTrace();
	      }
	  }
	
	  // Connection 객체 반환하는 메서드
	  private Connection getConnection() throws SQLException {
	      Connection con = DriverManager.getConnection(JDBC_URL, USER, PASSWD);
	      return con;
	  }
	  
	  /* login() 메서드 : 로그인 처리
	   * @param (MemberVO vo)
	   * @return MemberVO 자료형 리턴
	   */
	  public MemberVO login(MemberVO vo){
		  Connection con = null;
		  PreparedStatement pstmt = null;
		  ResultSet rs = null;
		  MemberVO memVO = null; // 인스턴스의 값이 null 그대로이면 일치하는 정보가 존재하지 않는다는 의미
		  
		  try {
			  con = getConnection();
			  StringBuffer query = new StringBuffer();
			  query.append("select m_id, m_name, m_email from t_member ");
			  query.append("where m_id = ? and m_passwd = ?");
			  
			  pstmt = con.prepareStatement(query.toString());
			  pstmt.setString(1, vo.getM_id());
			  pstmt.setString(2, vo.getM_passwd());
			  rs = pstmt.executeQuery();
			  
			  if(rs.next()) {
				  memVO = new MemberVO(); // 일치하는 레코드가 존재한다면 인스턴스를 생성하여 데이터 설정
				  memVO.setM_id(rs.getString("m_id"));
				  memVO.setM_name(rs.getString("m_name"));
				  memVO.setM_email(rs.getString("m_email"));
			  }
			 System.out.println(memVO); // 디버깅하기 위한 코드
		  } catch(Exception e) {
			  e.printStackTrace();
		  } finally {
			  try {
				  if(rs != null) rs.close();
				  if(pstmt != null) pstmt.close();
				  if(con != null) con.close();
			  } catch (SQLException e) {
				  e.printStackTrace();
			  }
		  }
		  
		  return memVO;
	  }
}
