package com.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCTemplate {
    // 데이터베이스 연결 관련 상수 선언
    private static final String JDBC_URL = "jdbc:oracle:thin:@127.0.0.1:1521/xepdb1";
    private static final String USER = "javauser";
    private static final String PASSWD = "java1234";
    
    // 1. Connectin이 필요할 때마다 직접 데이터베이스 서버에 접속해서 연결 요청
    public static Connection getConnection() {
    	Connection conn = null;
    	try {
    		Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(JDBC_URL, USER, PASSWD);
			conn.setAutoCommit(false); // 자동 커밋 안 함
    	} catch (ClassNotFoundException cnfe) {
    		cnfe.printStackTrace();
    	} catch (SQLException se) {
    		se.printStackTrace();
    	}
    	return conn;
    }
    
    public static void commit(Connection conn) {
    	try {
    		if(conn !=null && !conn.isClosed()) 
    			conn.commit();
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }
    
    public static void rollback(Connection conn) {
    	try {
    		if(conn !=null && !conn.isClosed())
				conn.rollback();
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }
    
    public static void close(Connection conn) {
    	try {
    		if(conn != null && !conn.isClosed())
    			conn.close();
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }
    public static void close(PreparedStatement pstmt) {
    	try {
    		if(pstmt != null && !pstmt.isClosed())
    			pstmt.close();
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }
    public static void close(ResultSet rset) {
    	try {
    		if(rset != null && !rset.isClosed())
    			rset.close();
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }
}
