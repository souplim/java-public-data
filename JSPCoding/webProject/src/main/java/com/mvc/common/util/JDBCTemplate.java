package com.mvc.common.util;

import java.sql.Connection;
//import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class JDBCTemplate {
//	private static final String JDBC_URL = "jdbc:oracle:thin:@127.0.0.1:1521/xepdb1";
//	private static final String USER = "javauser";
//	private static final String PASSWD = "java1234";
	
	private static JDBCTemplate instance = null;
	public static JDBCTemplate getInstance() {
		if(instance == null)
			instance = new JDBCTemplate();
		return instance;
	}
	
	private JDBCTemplate() {}
	
	public static Connection getConnection() throws Exception {
//		Connection conn = null;
//		
//		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			conn = DriverManager.getConnection(JDBC_URL, USER, PASSWD);
//			conn.setAutoCommit(false);
//		} catch (ClassNotFoundException cnfe) {
//			cnfe.printStackTrace();
//		} catch (SQLException se) {
//			se.printStackTrace();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return conn;
		
		// DataSource 열기, 커넥션 풀 사용
		Context ctx = new InitialContext();
		DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/Oracle18c");
		return ds.getConnection();
	}
	
	public static void close(Connection conn) {
		try {
			if(conn != null && !conn.isClosed())
				conn.close();
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}
	public static void close(PreparedStatement ptsmt) {
		try {
			if(ptsmt != null && !ptsmt.isClosed())
				ptsmt.close();
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}
	public static void close(ResultSet rs) {
		try {
			if(rs != null && !rs.isClosed())
				rs.close();
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}
}
