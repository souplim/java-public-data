package subject_management;

import java.sql.*;
import java.util.ArrayList;

/* DAO(Data Access Object) 클래스가 데이터 처리의 궁극적인 단계이다.
 * CRUD 프로그램 구현
 * 기본적인 데이터 처리 기능인 입력(create, insert), 조회(read(또는 retrieve), select), 수정(update),
 * 삭제(delete) 기능을 구현한 데이터베이스 프로그램*/
public class SubjectDAO {
    // 데이터베이스 연결 관련 상수 선언
    private static final String JDBC_URL = "jdbc:oracle:thin:@127.0.0.1:1521/xepdb1";
    private static final String USER = "javauser";
    private static final String PASSWD = "java1234";

    // 하나의 인스턴스만 가지게 하기 위해 싱글톤으로 생성
    // 클래스 자신의 타입으로 정적 필드 선언
    private static SubjectDAO instance = null;
    // 외부에서 호출할 수 있는 정적 메소드인 getInstnace() 선언하여 인스턴스를 반환
    public static SubjectDAO getInstance(){
        if(instance == null)
            instance = new SubjectDAO();
        return instance;
    }

    // 외부에서 new 연산자로 생성자를 호출할 수 없도록 막기 위해 접근제어자 설정
    private SubjectDAO(){
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

    // 학과 테이블에서 모든 레코드를 반환하는 메서드
    // ArrayList<SubjectVO> 자료형을 리턴
    public ArrayList<SubjectVO> getSubjectTotal(){
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT no, s_num, s_name FROM subject ORDER BY no");

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        SubjectVO svo = null;
        ArrayList<SubjectVO> list = new ArrayList<>();

        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql.toString());
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
            try {
                if(rs != null) rs.close();
                if(pstmt != null) pstmt.close();
                if(conn != null) conn.close();
            } catch (SQLException e){
                System.out.println("DB 연동 해제 ERROR = ["+e+"]");
            }
        }
        return list;
    }
}
