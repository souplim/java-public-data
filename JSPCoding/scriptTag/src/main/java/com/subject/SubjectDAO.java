package com.subject;

import java.sql.*;
import java.util.ArrayList;

import static com.common.JDBCTemplate.*;

/* DAO(Data Access Object) 클래스가 데이터 처리의 궁극적인 단계이다.
 * CRUD 프로그램 구현
 * 기본적인 데이터 처리 기능인 입력(create, insert), 조회(read(또는 retrieve), select), 수정(update),
 * 삭제(delete) 기능을 구현한 데이터베이스 프로그램*/
public class SubjectDAO {
//    // 데이터베이스 연결 관련 상수 선언
//    private static final String JDBC_URL = "jdbc:oracle:thin:@127.0.0.1:1521/xepdb1";
//    private static final String USER = "javauser";
//    private static final String PASSWD = "java1234";
//
//    // 하나의 인스턴스만 가지게 하기 위해 싱글톤으로 생성
//    // 클래스 자신의 타입으로 정적 필드 선언
//    private static SubjectDAO instance = null;
//    // 외부에서 호출할 수 있는 정적 메소드인 getInstnace() 선언하여 인스턴스를 반환
//    public static SubjectDAO getInstance(){
//        if(instance == null)
//            instance = new SubjectDAO();
//        return instance;
//    }
//
//    // 외부에서 new 연산자로 생성자를 호출할 수 없도록 막기 위해 접근제어자 설정
//    private SubjectDAO(){
//        try {
//            Class.forName("oracle.jdbc.OracleDriver");
//        } catch(ClassNotFoundException e){
//            e.printStackTrace();
//        }
//    }
//
//    // Connection 객체 반환하는 메서드
//    private Connection getConnection() throws SQLException {
//        Connection con = DriverManager.getConnection(JDBC_URL, USER, PASSWD);
//        return con;
//    }

    // 학과 테이블에서 모든 레코드를 반환하는 메서드
    /* @return ArrayList<SubjectVO> 자료형 리턴
     */
    public ArrayList<SubjectVO> getSubjectTotal(SubjectVO vo){
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT no, s_num, s_name FROM subject ");
        if(vo!=null)
            sql.append("WHERE s_name like ?");
        sql.append("ORDER BY no");

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        SubjectVO svo = null;
        ArrayList<SubjectVO> list = new ArrayList<>();

        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql.toString());
            if(vo!=null)
                pstmt.setString(1, "%"+vo.getS_name()+"%");
            rs = pstmt.executeQuery();

            // ResultSet의 결과에서 모든 행을 각각의 SubjectVO 객체에 저장
            while(rs.next()){
                //한 행의 학과 정보 저장할 VO 객체 생성
                svo = new SubjectVO();
                // 한 행의 학과 정보 저장
                svo.setNo(rs.getInt("no"));
                svo.setS_num(rs.getString("s_num"));
                svo.setS_name(rs.getString("s_name"));

                // ArrayList 객체에 원소로 추가
                list.add(svo);
            }
        } catch(SQLException se){
            System.out.println("조회에 문제가 있어 잠시 후에 다시 진행해주세요");
        } catch(Exception e){
            System.out.println("ERROR=["+e+"]");
        } finally {
//            try {
//                if(rs != null) rs.close();
//                if(pstmt != null) pstmt.close();
//                if(conn != null) conn.close();
//            } catch (SQLException e){
//                System.out.println("DB 연동 해제 ERROR = ["+e+"]");
//            }
        	
        	close(rs);
        	close(pstmt);
        	close(conn);
        }
        return list;
    }

    // 학과번호 자동 구하기
    /* @return String 자료형 리턴
     */
    public String getSubjectNum(){
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT '0'||(NVL(MAX(S_NUM),'01')+1) AS subjectNum FROM SUBJECT");

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String snum = ""; // 없을 때 null을 반환해야 하기 때문에 초기값 null 추어야 함

        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql.toString());
            rs = pstmt.executeQuery();
            // ResultSet의 결과에서 그 다음에 저장할 학과번호를 String에 저장
            while(rs.next()){
                // 한 행의 학과 정보 저장
                snum = rs.getString("subjectNum"); // 별칭 주어서 가져오기
            }
        } catch(SQLException se){
            System.out.println("조회에 문제가 있어 잠시 후에 다시 진행해주세요");
        } catch(Exception e){
            System.out.println("ERROR=["+e+"]");
        } finally {
//            try {
//                if(rs != null) rs.close();
//                if(pstmt != null) pstmt.close();
//                if(conn != null) conn.close();
//            } catch (SQLException e){
//                System.out.println("DB 연동 해제 ERROR = ["+e+"]");
//            }
        	
        	close(rs);
        	close(pstmt);
        	close(conn);
        }
        return snum;
    }

    /* 학과 테이블에 데이터 입력
     * @param svo
     * @return boolean 자료형 리턴
     */
    public boolean subjectInsert(SubjectVO svo){
        StringBuffer sql = new StringBuffer();
        sql.append("INSERT INTO SUBJECT(no, s_num, s_name) VALUES(subject_seq.nextval, ?, ?)");

        Connection conn = null;
        PreparedStatement pstmt = null;
        boolean success = false;

        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql.toString());

            pstmt.setString(1, svo.getS_num());
            pstmt.setString(2, svo.getS_name());

            int insertCount = pstmt.executeUpdate(); // 쿼리문 실행 - 입력이 정상적으로 완료되면 적용된 행의 수인 1 반환

            if (insertCount == 1) {
                success = true;
                commit(conn);
            }
        } catch(SQLException se){
        		se.printStackTrace();
                System.out.println("입력에 문제가 있어 잠시 후에 다시 진행해주세요");
                rollback(conn);
        } catch(Exception e){
                System.out.println("ERROR=[" + e + "]");
                rollback(conn);
        } finally{
//            try {
//                if (pstmt != null) pstmt.close();
//                if (conn != null) conn.close();
//            } catch (SQLException e) {
//                System.out.println("DB 연동 해제 ERROR = [" + e + "]");
//            }
        	close(pstmt);
        	close(conn);
        }
        return success;
    }

    /* 학과 테이블에 학과명 수정. 학과번호는 수정 불가
     * @param svo
     * @return boolean 자료형 리턴
     */
    public boolean subjectUpdate(SubjectVO svo){
        StringBuffer sql = new StringBuffer();
        sql.append("UPDATE SUBJECT SET s_name = ? WHERE no = ?");

        Connection conn = null;
        PreparedStatement pstmt = null;
        boolean success = false;

        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql.toString());

            pstmt.setString(1, svo.getS_name());
            pstmt.setInt(2, svo.getNo()); // update, delete의 기준은 기본키

            int insertCount = pstmt.executeUpdate();

            if (insertCount == 1) // 입력이 정상적으로 완료되면 적용된 행의 수인 1 반환
                success = true;
        } catch(SQLException se){
            System.out.println("수정에 문제가 있어 잠시 후에 다시 진행해주세요");
        } catch(Exception e){
            System.out.println("ERROR=[" + e + "]");
        } finally{
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.out.println("DB 연동 해제 ERROR = [" + e + "]");
            }
        }
        return success;
    }

    /* 학과에 소속된 학생이 있는지 확인. 학과에 학생이 들어가있으면 학과 지울 수 없음
     * @return int 자료형 리턴
     */
    public int studentDataCheck(SubjectVO svo){
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT COUNT(sd_num) " +
                   "FROM STUDENT " +
                   "WHERE s_num = ?");

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int count = 0;

        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql.toString());
            pstmt.setString(1, svo.getS_num()); // update, delete의 기준은 기본키
            rs = pstmt.executeQuery();
            if(rs.next())
                count = rs.getInt(1);

        } catch(SQLException se){
            System.out.println("조회에 문제가 있어 잠시 후에 다시 진행해주세요");
        } catch(Exception e){
            System.out.println("ERROR=[" + e + "]");
        } finally{
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.out.println("DB 연동 해제 ERROR = [" + e + "]");
            }
        }
        return count;
    }

    /* 학과 테이블의 데이터 삭제. 소속된 학생이 존재하지 않을 경우만 삭제 진행
     * @param svo SubjectVO 클래스
     * @return boolean 자료형 리턴
     */
    public boolean subjectDelete(SubjectVO svo){
        StringBuffer sql = new StringBuffer();
        sql.append("DELETE FROM SUBJECT WHERE no = ?");

        Connection conn = null;
        PreparedStatement pstmt = null;
        boolean success = false;

        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql.toString());

            pstmt.setInt(1, svo.getNo()); // update, delete의 기준은 기본키

            int insertCount = pstmt.executeUpdate();

            if (insertCount == 1) // 삭제가 정상적으로 완료되면 적용된 행의 수인 1 반환
                success = true;
        } catch(SQLException se){
            System.out.println("삭제에 문제가 있어 잠시 후에 다시 진행해주세요");
        } catch(Exception e){
            System.out.println("ERROR=[" + e + "]");
        } finally{
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.out.println("DB 연동 해제 ERROR = [" + e + "]");
            }
        }
        return success;
    }
}
